/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.view.component.swing;

import javax.swing.JComboBox;
import lombok.Setter;

/**
 *
 * @author alice
 */
@Setter
public class SearchableComboBox<E>  extends JComboBox<E>{
   
    public SearchableComboBox( ) {
        setUI(new ComboBoxSuggestionUI());       
    }
  
}
