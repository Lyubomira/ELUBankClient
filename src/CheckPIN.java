/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class CheckPIN {
        
        private static final int[] weights = { 2, 4, 8, 5, 10, 9, 7, 3, 6 };

        private String pin = null;
       
        
        public CheckPIN(String pin) {
                this.pin = pin;
                
                
        }
        
    public String getPin() {
                return pin;
        }

   
    public void setPin(String egn) {
                this.pin = egn;
        }
        
        
   
    
    
        public boolean isValid() {
                int year;
                int month;
                int day;
                int num; 
                int checkSum = 0;
                
                if(pin.length() != 10) {
                        return false;
                }
                try {
                        Long.parseLong(pin);
                } catch (NumberFormatException ex) {
                        return false;                   
                }
                year = Integer.parseInt(pin.substring(0,2));
                if(year < 0 || year > 99) {
                }
                month = Integer.parseInt(pin.substring(2,4));
                if(month > 20 && month < 40) {
                        month -= 20;
                } else if(month > 40) {
                        month -=40;                     
                }
                if (month < 1 || month > 12) {
                        return false;
                }
                day = Integer.parseInt(pin.substring(4, 6));
                if(day < 1 || day > 31) {
                        return false;
                }
                num = Integer.parseInt(pin.substring(6, 9));
                for(int i = 0; i < pin.length() - 1; i++) {
                        checkSum += (int)(pin.charAt(i) - '0')*weights[i];
                }
                checkSum %= 11;
                if(checkSum != (int)(pin.charAt(9) - '0')) {
                        return false;
                }
                return true;
        }
        
        
        
}
