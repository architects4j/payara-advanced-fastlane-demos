package my.company.cdi.demo.music;

import javax.inject.Named;

//@MusicalInstrument(InstrumentType.STRING)
@Named("string")
class Violin implements Instrument {
    @Override
    public String sound() {
        return "violin";
    }
}
