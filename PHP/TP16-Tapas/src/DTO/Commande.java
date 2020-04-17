
package DTO;

import java.time.LocalDate;

public class Commande 
{
    private int _idCommande;
    private LocalDate _dateCommande;
    private int _idTable;

    public int getIdCommande() {
        return _idCommande;
    }

    public void setIdCommande(int _idCommande) {
        this._idCommande = _idCommande;
    }

    public LocalDate getDateCommande() {
        return _dateCommande;
    }

    public void setDateCommande(LocalDate _dateCommande) {
        this._dateCommande = _dateCommande;
    }

    public int getIdTable() {
        return _idTable;
    }

    public void setIdTable(int _idTable) {
        this._idTable = _idTable;
    }
    
    
}
