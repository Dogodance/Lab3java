import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;


/**
 * Ёто SWING - компонент, который используетс€ дл€ отображени€ состо€ни€ €чеек на карте
 * Ётот класс используетс€ как пользовательский Swing компонент дл€ представлени€ карты
 * €чеек в 2D виде. ячейки имеют несколько состо€ний, основные - €вл€етс€ ли €чейка проходимой
 * или нет. Ќаследуетс€ от JComponent
 */
public class JMapCell extends JComponent
{
    //”станавливаем размеры €чейки на экране, в нашем случае она 12x12 пикселей
    private static final Dimension CELL_SIZE = new Dimension(12, 12);

    /** «начение true говорит, что €чейка €вл€етс€ стартом или финишем **/
    boolean endpoint = false;
    
    
    /** «начение true указывает проходимость точки, false о непроходимости **/
    boolean passable = true;
    
    /**
     * «начение true указывает на то, €вл€етс€ ли €чейка частью между началом и концом
     **/
    boolean path = false;

    /**
     *  онструктор создает новую карту €чеек с установленной "проходимостью, устанавлива€
     * в €чейки свойства проходимости.
     **/
    public JMapCell(boolean pass)
    {
        // ”станавливает размер €чейки
        setPreferredSize(CELL_SIZE);

        setPassable(pass);
    }
    
    /**  онструктор создает новую карту €чеек со значение проходимости по умолчанию(True). **/
    public JMapCell()
    {
        this(true);
    }
    
    /** ќтмечает эту €чейку как начальную или конечную. **/
    public void setEndpoint(boolean end)
    {
        endpoint = end;
        updateAppearance();
    }
    
    /**
     * ”становка проходимости €чейки.
     * ѕосле установки проходимости обновл€етс€ цвет €чейки в красный или обратно
     **/
    public void setPassable(boolean pass)
    {
        passable = pass;
        updateAppearance();
    }
    
    /** ѕроверка проходимости **/
    public boolean isPassable()
    {
        return passable;
    }
    
    /** ѕереключение проходимости на противоположенное значение **/
    public void togglePassable()
    {
        setPassable(!isPassable());
    }
    
    /**
     * ќтмечает €чейку как часть пути A* алгоритма
     * ѕосле установки пути обновл€етс€ цвет €чейки в зеленый
     * **/
    public void setPath(boolean path)
    {
        this.path = path;
        updateAppearance();
    }
    
    /**
     * ¬оспомогательный метод позвол€ет обновить цвета €чеек на основе еЄ состо€ни€
     **/
    private void updateAppearance()
    {
        if (passable)
        {
            setBackground(Color.WHITE);
            if (endpoint)
                setBackground(Color.CYAN);
            else if (path)
                setBackground(Color.GREEN);
        }
        else
        {
            setBackground(Color.RED);
        }
    }

    /**
     * –еалезаци€ метода отрисовки €чейки и еЄ цвета.
     **/
    @Override
    protected void paintComponent(Graphics g)
    {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
