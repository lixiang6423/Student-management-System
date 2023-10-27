package appstu.tuil;

import java.util.Vector;

public class ProduceMaxBh {
    public String getMaxbh(String sqlStr, String whereID) {

        RetrieveObject reobject = new RetrieveObject();
        Vector vdata = null;
        Object obj = null;
        vdata = reobject.getObjectRow(sqlStr);
        String maxbh = null, newbh = null;
        if (vdata.size()==1) {
            newbh = whereID + "01";
        } else {
            maxbh = String.valueOf(vdata.lastElement());
            String substr = maxbh.substring(maxbh.length() - 2, maxbh.length());
            substr = String.valueOf(Integer.parseInt(substr) +1);
            if (substr.length() == 1)
                substr = "0" + substr;
            newbh = whereID + substr;
        }
        return  newbh;
    }
    public String getMaxbh(String sqlStr){
        RetrieveObject reobject = new RetrieveObject();
        Vector vdata = null;
        Object obj = null;
        vdata = reobject.getObjectRow(sqlStr);
        String maxbh = null, newbh = null;
        if (vdata.isEmpty()) {
            newbh = "0001";
        } else {
            maxbh = String.valueOf(vdata.lastElement());
            String substr = maxbh.substring(maxbh.length() - 4, maxbh.length());
            substr = String.valueOf(Integer.parseInt(substr) +1);
            if (substr.length() == 1)
                substr = "000" + substr;
            else if(substr.length()==2)
                substr="00"+substr;
            else if (substr.length()==3) {
                substr="0"+substr;

            }
            newbh =substr;
        }
        return  newbh;
    }
    public String getMaxbh(String sqlStr,boolean  b){
        RetrieveObject reobject = new RetrieveObject();
        Vector vdata = null;
        Object obj = null;
        vdata = reobject.getObjectRow(sqlStr);
        String maxbh = null, newbh = null;
        if (vdata.isEmpty()) {
            newbh = "01";
        } else {
            maxbh = String.valueOf(vdata.lastElement());
            String substr = maxbh.substring(maxbh.length() - 2, maxbh.length());
            substr = String.valueOf(Integer.parseInt(substr) +1);
            if (substr.length() == 1)
                substr = "0" + substr;
            newbh =substr;
        }
        return  newbh;
    }
}
