/**
 * Класс вершин пути в сгенерированном пути
 * Класс представляет одиночный шаг в путь сгенерированным алгоритмом A*
 * Класс состоит из локации, предидущей точкой пути и некоторой стоимостью
 * для определения лучшего пути
 **/
public class Waypoint
{
    /** Локация точки. **/
    Location loc;

    /**
     * Предидущая точка пути, или <code>null</code> если это начала пути
     **/
    Waypoint prevWaypoint;

    /**
     * Поле хранит общее количество предидущей стоймости получаймой с начальной
     * локации, до этой точки проходящих через цепочку точек. Это фактическая стоимость
     * путь без прогнозирования и оценок.
     **/
    private float prevCost;

    /**
     * Поле хранит оставшуюся стоимость путешествия от текущей точки до финальной.
     **/
    private float remainingCost;


    /**
     * Конструктор для новой точки с определенной локацией. Предидущая точка
     * может быть опционально определена или может быть <code>null</code>, что
     * будет показывать, что точка является началом пути.
     **/
    public Waypoint(Location loc, Waypoint prevWaypoint)
    {
        this.loc = loc;
        this.prevWaypoint = prevWaypoint;
    }


    /** Возврат локации точки **/
    public Location getLocation()
    {
        return loc;
    }
    
    /**
     * Возврат предидущей точки, может быть <code>null</code> если это старт пути
     **/
    public Waypoint getPrevious()
    {
        return prevWaypoint;
    }
    
    /**
     * Сеттер который устанавливает предидущую стоимость и оставщуюся стоимость
     * пути в одном методе.
     **/
    public void setCosts(float prevCost, float remainingCost)
    {
        this.prevCost = prevCost;
        this.remainingCost = remainingCost;
    }

    /**
     * Возвращает текущую стоимость пройденного пути от начала до текущей точки
     **/
    public float getPreviousCost()
    {
        return prevCost;
    }

    /**
     * Возвращает оставшуюся стоимость пути от текущей точки до конца
     **/
    public float getRemainingCost()
    {
        return remainingCost;
    }

    /**
     * Возвращает общую стоймость всего пути для текущей точки. Включает в себя сумму
     * стоймости от начала до текущей точки, а также стоимость от текущей точки до
     * конца.
     **/
    public float getTotalCost()
    {
        return prevCost + remainingCost;
    }
}

