package com.norpactech.pf.imp.repository;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 *  
 * For license details, see the LICENSE file in this project root.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.UUID;
import com.norpactech.pf.utils.ApiResponse;
import com.norpactech.pf.imp.dto.DataIndexPutApiRequest;
import com.norpactech.pf.imp.dto.DataIndexPostApiRequest;
import com.norpactech.pf.imp.dto.DataIndexDeleteApiRequest;

import com.norpactech.pf.imp.model.DataIndex;

public class DataIndexRepository extends ParetoNativeRepository<DataIndex> {
  
  private static final String RELATIVE_URL = "/data-index";

  @Override
  protected String getRelativeURL() {
    return RELATIVE_URL;
  }

  public DataIndex get(UUID id) throws Exception {
    return super.findOne(DataIndex.class, new HashMap<>(Map.of("id", id)));
  }

  public DataIndex findOne(UUID idTenant, UUID idDataObject, String name) throws Exception {
    return super.findOne(DataIndex.class, new HashMap<>(Map.of("idTenant", idTenant, "idDataObject", idDataObject, "name", name)));
  }
  
  public List<DataIndex> find(Map<String, Object> params) throws Exception {
    return super.find(DataIndex.class, params);
  }
    
  public ApiResponse save(DataIndexPostApiRequest request) throws Exception {
    return super.post(toParams(request));
  }  
  
  public ApiResponse save(DataIndexPutApiRequest request) throws Exception {
    return super.put(toParams(request));
  } 

  public ApiResponse delete(DataIndexDeleteApiRequest request) throws Exception {
    return super.delete(toParams(request));
  }
}