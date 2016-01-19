/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eancode;

/**
 *
 * @author santosh
 */
public class SaleBeanData {
    String srno, matcode, matname, qtypcs, qty, unitprice, totprice;
    
    
     public SaleBeanData(String srno, String matcode, String matname, String qtypcs, String qty, String unitprice, String totprice) {
        this.srno = srno;
        this.matcode = matcode;
        this.matname = matname;
        this.qtypcs = qtypcs;
        this.qty = qty;
        this.unitprice = unitprice;
        this.totprice = totprice;
    }

    public String getsrno() {
        return srno;
    }

    public void setsrno(String srno) {
        this.srno = srno;
    }

    public String getmatcode() {
        return matcode;
    }

    public void setmatcode(String matcode) {
        this.matcode = matcode;
    }

    public String getmatname() {
        return matname;
    }

    public void setmatname(String matname) {
        this.matname = matname;
    }

    public String getqtypcs() {
        return qtypcs;
    }

    public void setqtypcs(String qtypcs) {
        this.qtypcs = qtypcs;
    }

    public String getqty() {
        return qty;
    }

    public void setqty(String qty) {
        this.qty = qty;
    }

    public String getunitprice() {
        return unitprice;
    }

    public void setunitprice(String unitprice) {
        this.unitprice = unitprice;
    }

    public String gettotprice() {
        return totprice;
    }

    public void settotprice(String totprice) {
        this.totprice = totprice;
    }

   


    

  
    
}
