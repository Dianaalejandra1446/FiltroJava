
package com.campusland.respository;


public interface RepositoryImpuestoRef<T>  {

    T porCodigo(int id);

    void guardar(T entidad);
  
}

