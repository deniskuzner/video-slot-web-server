/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author User
 */
public class SpinLinePayout {

    private int gameId;
    private int spinId;
    private int linePayoutId;

    public SpinLinePayout() {
    }

    public SpinLinePayout(int gameId, int spinId, int linePayoutId) {
        this.gameId = gameId;
        this.spinId = spinId;
        this.linePayoutId = linePayoutId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getSpinId() {
        return spinId;
    }

    public void setSpinId(int spinId) {
        this.spinId = spinId;
    }

    public int getLinePayoutId() {
        return linePayoutId;
    }

    public void setLinePayoutId(int linePayoutId) {
        this.linePayoutId = linePayoutId;
    }

}
