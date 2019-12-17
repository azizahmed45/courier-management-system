/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courier.management.system.models;

/**
 *
 * @author Aziz
 */
public class Transaction {
    int parcelId;
    String type;
    String fromBranch;
    String toBranch;
    String description;

    public Transaction(int parcelId, String type, String fromBranch, String toBranch, String description) {
        this.parcelId = parcelId;
        this.type = type;
        this.fromBranch = fromBranch;
        this.toBranch = toBranch;
        this.description = description;
    }

    public int getParcelId() {
        return parcelId;
    }

    public void setParcelId(int parcelId) {
        this.parcelId = parcelId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFromBranch() {
        return fromBranch;
    }

    public void setFromBranch(String fromBranch) {
        this.fromBranch = fromBranch;
    }

    public String getToBranch() {
        return toBranch;
    }

    public void setToBranch(String toBranch) {
        this.toBranch = toBranch;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    
}
