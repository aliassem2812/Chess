package chessgame;

import java.util.LinkedList;

/**
 *
 * @author Ali Haydar
 */
public class Piece {
    int xp;
    int yp;

    int x;
    int y;
    boolean isWhite;
    LinkedList<Piece> ps;
    String name;
    public Piece(int xp, int yp, boolean isWhite,String n, LinkedList<Piece> ps) {
        this.xp = xp;
        this.yp = yp;
        x=xp*100;
        y=yp*100;
        this.isWhite = isWhite;
        this.ps=ps;
        name=n;
        ps.add(this);
    }

    public void move(int xp,int yp){
        if (ChessGame.getPiece(xp*100, yp*100)!=null) {
            if (ChessGame.getPiece(xp*100, yp*100).isWhite!=isWhite) {
                ChessGame.getPiece(xp * 100, yp * 100).kill();
            }else{
                x=this.xp*100;
                y=this.yp*100;
                return;
            }
        }
        this.xp=xp;
        this.yp=yp;
        x=xp*100;
        y=yp*100;
    }
    public void kill(){
        ps.remove(this);
    }
}
