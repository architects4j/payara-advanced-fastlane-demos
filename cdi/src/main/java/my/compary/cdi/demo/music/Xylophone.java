package my.compary.cdi.demo.music;

import javax.inject.Named;

//@MusicalInstrument(InstrumentType.PERCUSSION)
@Named("percussion")
class Xylophone implements Instrument {
    @Override
    public String sound() {
        return "xylophone";
    }
}
