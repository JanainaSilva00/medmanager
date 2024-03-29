/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medmanager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 *
 * @author Janaina
 */
public class ConversorDateString 
        extends org.jdesktop.beansbinding.Converter<Date,String>{
    
    private SimpleDateFormat df;
    
    public ConversorDateString(){
        df = new SimpleDateFormat("dd/MM/yyyy");
    }
    
    @Override
    public String convertForward(Date s) {
        return df.format(s);
    }

    @Override
    public Date convertReverse(String t) {
        try{
            return new Date(df.parse(t).getTime());
        }catch(ParseException e){
            return null;
        }
    }   
}
