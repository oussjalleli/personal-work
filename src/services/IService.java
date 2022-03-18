/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface IService<T> {
    public void ajouterNews(T t);
    public List<T> afficherNews();
    public void modifierNews(T t);
    public void supprimerNews(int id);
    
    
  
}
