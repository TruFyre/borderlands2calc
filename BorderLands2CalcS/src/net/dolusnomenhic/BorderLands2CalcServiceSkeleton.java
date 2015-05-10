
/**
 * BorderLands2CalcServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
    package net.dolusnomenhic;

import cmd.borderLands2Calc.Calculator;
    /**
     *  BorderLands2CalcServiceSkeleton java skeleton for the axisService
     */
    public class BorderLands2CalcServiceSkeleton{
        
         
        /**
         * Auto generated method signature
         * 
                                     * @param trueDpsRequest 
             * @return trueDpsResponse 
         */
        
                 public net.dolusnomenhic.TrueDpsResponse calcTrueDps(net.dolusnomenhic.TrueDpsRequest trueDpsRequest)
            {
                
                float damage = trueDpsRequest.getDamage();
                float fireRate = trueDpsRequest.getFireRate();
                float reloadTime = trueDpsRequest.getReloadTime();
                float clipSize = trueDpsRequest.getClipSize();
                float ammoPerShot = trueDpsRequest.getAmmoPerShot();
                	 
                Calculator calculator = new Calculator();
                
                float trueDps = calculator.trueDps(damage, fireRate, reloadTime, clipSize, ammoPerShot);
                
                
                TrueDpsResponse trueDpsResponse = new TrueDpsResponse();
                
                trueDpsResponse.setTrueDps(trueDps);
                
                return trueDpsResponse;
        }
     
    }
    