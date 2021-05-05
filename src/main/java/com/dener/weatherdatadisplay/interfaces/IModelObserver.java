package com.dener.weatherdatadisplay.interfaces;

import com.dener.weatherdatadisplay.model.Tempo;
import java.util.ArrayList;

public interface IModelObserver {

    public void update(ArrayList<Tempo> tempos);
}
