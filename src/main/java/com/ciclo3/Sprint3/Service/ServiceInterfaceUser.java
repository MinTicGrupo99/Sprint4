package com.ciclo3.Sprint3.Service;

import com.ciclo3.Sprint3.Models.UsersApplication;

import java.util.List;
public interface ServiceInterfaceUser {
    //Metodo para ver lista de Usuarios de la aplicacion
    public List<UsersApplication> getUsersApplication();


    //Metodo que nos trae un solo usuario
    public UsersApplication getOnlyOneUsersApplication(String userApplication) throws Exception;


    //Metodo que nos crea un usuario
    public String setCreateUsersApplication(UsersApplication UsersApplicationIn);


    //Metodo que nos permita actualizar los atributos de un usuario
    public UsersApplication getUpdateUsersApplication(UsersApplication UsersApplicationIn) throws Exception;

    //Metodo que elimina un usuario de la aplicacion
    public String getDeleteUsersApplication(String userApplication);
}
