/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mei.contacts_for_desktop.util.Interface;

import java.time.LocalDate;

/**
 *
 * @author Mei
 */
public interface ILocalDateAdapter {

    String marshal(LocalDate v) throws Exception;

    LocalDate unmarshal(String v) throws Exception;
    
}
