package my.compary.cdi.demo.music;

import javax.enterprise.inject.Default;
import javax.inject.Named;

//@MusicalInstrument(InstrumentType.KEYBOARD)
@Named("keyboard")
@Default
class Piano implements Instrument {
    @Override
    public String sound() {
        return "piano";
    }
}
