/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transfer;

import Domain.Position;
import Domain.SPosition;
import Domain.Symbol;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author User
 */
public class WebServerTransferObject implements Serializable {
    
    public List<Symbol> symbols;
    public List<Position> positions;
    public List<SPosition> sPositions;
    
    public String message;
    public boolean signal;
    
}
