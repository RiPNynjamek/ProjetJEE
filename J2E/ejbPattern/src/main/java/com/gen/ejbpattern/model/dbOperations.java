/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.gen.ejbpattern.model;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Timestamp;
/**
 *
 * @author Cyril
 */
@Stateless
@LocalBean
public class dbOperations {

    @EJB
    private dbConnection dbConnection;
    private float tauxConfiance;
    public float searchWord(String message, String key){
        System.out.println("search ");
        List<String> listMots = new ArrayList();
        List<String> motsTrouve = new ArrayList();
        Connection connection = dbConnection.connection();
        try{
            Statement state = connection.createStatement();
            String query ="SELECT mot FROM dico";
            String colone = "mot";
            System.out.println("query :");
            ResultSet result = state.executeQuery(query);
            String[] tableMessage = message.split(" ");
            for (int i=0; i<tableMessage.length; i++){
                listMots.add(tableMessage[i]);
            }
            while(result.next()){
                String word = result.getString(colone);
                word = word.replaceAll("\\n", "");
                for (int i=0; i<listMots.size(); i++){
                    if(listMots.get(i).equals(word)){
                        System.out.println("contient " + word);
                        motsTrouve.add(word);
                    }
                }
            }
            insertHistory(listMots, key);
        }catch(Exception e){
            e.printStackTrace();
        }
        tauxConfiance = (float) motsTrouve.size() / (float)listMots.size() ;
        tauxConfiance = tauxConfiance * 100;
        
        return tauxConfiance;
        
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void insertHistory(List<String> mots, String key) throws SQLException
    {
        Connection connection = dbConnection.connection();
        
        try
        {
            String message = "";
            
            for (String mot : mots) {
                message += mots;
                message += " ";
            }
            Timestamp date = new Timestamp(new java.util.Date().getTime());
            
            Statement state = connection.createStatement();
            String query = "INSERT INTO HISTORY(DATA, DECRYPTIONKEY, DATE) VALUES(" + message + ", " + key + ", " + date + ");";
            state.executeUpdate(query);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    
}
