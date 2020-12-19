package ui.PlayStyle;

public interface PlayStyle {

    public char getCurrentPlayerSymbol();

    public boolean play (int move);

    public boolean getWinState();

    public String getCurrentBoardString ();

}
