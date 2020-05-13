
package DTO;

import java.util.Date;


public class SessionTable 
{
    private int _idSession;
    private Date _dateDebut;
    private Date _dateFin;
    private int _nbClients;
    private int _idTable;

    public int getIdSession() {
        return _idSession;
    }

    public void setIdSession(int _idSession) {
        this._idSession = _idSession;
    }

    public Date getDateDebut() {
        return _dateDebut;
    }

    public void setDateDebut(Date _dateDebut) {
        this._dateDebut = _dateDebut;
    }

    public Date getDateFin() {
        return _dateFin;
    }

    public void setDateFin(Date _dateFin) {
        this._dateFin = _dateFin;
    }

    public int getNbClients() {
        return _nbClients;
    }

    public void setNbClients(int _nbClients) {
        this._nbClients = _nbClients;
    }
    
    public int getIdTable() {
        return _idTable;
    }

    public void setIdTable(int _idTable) {
        this._idTable = _idTable;
    }
    
    
}
