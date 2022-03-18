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
public interface IRService<R> {
    public void ajouterReponse(R r);
    public List<R> afficherReponse();
    public void modifierReponse(R r);
    public void supprimerReponse(int id);
}
