CREATE OR REPLACE PROCEDURE recalculate_impact_factor(
    id IN NUMBER)
IS
  product_reputation NUMBER(15,3);
  new_impact_factor  NUMBER(5,2);
  cus_id number(9);
  cus_reputation number(11,3);
  tmp_total_cus_reputation NUMBER(15,3);
  LV_SQL VARCHAR2(255);
  CURSOR feature_req_cur
  IS
    SELECT req.request_id,
      req.customer_id
    FROM spfeaturerequest req
    INNER JOIN spcustomer cus
    ON req.customer_id = cus.customer_id
    INNER JOIN spproduct prod
    ON prod.product_id   = cus.product_id
    WHERE prod.product_id=id
    AND req.isfreezed    =0;
  req_rec feature_req_cur%ROWTYPE;
  customer_cursor sys_refcursor;
BEGIN
  --DBMS_OUTPUT.PUT_LINE(id);
  LV_SQL := '';
  tmp_total_cus_reputation := 0;
  SELECT REPUTATION INTO product_reputation FROM SPPRODUCT WHERE PRODUCT_ID=id;
  DBMS_OUTPUT.PUT_LINE('product reputation::'||product_reputation);
  FOR req_rec IN feature_req_cur
  LOOP
    DBMS_OUTPUT.PUT_LINE('Request id:: '||req_rec.request_id);
    tmp_total_cus_reputation := 0;
    new_impact_factor:=0;
    OPEN customer_cursor FOR SELECT vote.customer_id,
    cus.reputation FROM SPFEATUREREQVOTEDETAIL vote inner join spcustomer cus ON vote.customer_id = cus.customer_id WHERE vote.request_id=req_rec.request_id;
      LOOP
        FETCH customer_cursor into cus_id,cus_reputation;
        exit when customer_cursor%notfound;
        DBMS_OUTPUT.PUT_LINE('Cus Id:: '||cus_id);
        DBMS_OUTPUT.PUT_LINE(cus_reputation);
        tmp_total_cus_reputation := tmp_total_cus_reputation + cus_reputation;
        DBMS_OUTPUT.PUT_LINE('Temp cus '||tmp_total_cus_reputation);
      END LOOP;
    CLOSE customer_cursor;
    new_impact_factor := (tmp_total_cus_reputation / product_reputation) * 100;
    LV_SQL := 'update spfeaturerequest set impact_factor = '||new_impact_factor||', ROWMODIFIEDDATE=CURRENT_TIMESTAMP WHERE REQUEST_ID='||req_rec.request_id;
    EXECUTE IMMEDIATE LV_SQL;
    DBMS_OUTPUT.PUT_LINE('new impact:: '||new_impact_factor);
    
  END LOOP;
  COMMIT;
  EXCEPTION 
    WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('No data Found');
    WHEN TOO_MANY_ROWS THEN
      DBMS_OUTPUT.PUT_LINE('Too many rows');
END;
/