package pl.akolata.s13803.riak.crud;

import com.basho.riak.client.api.commands.kv.UpdateValue;
import lombok.RequiredArgsConstructor;
import pl.akolata.s13803.riak.model.PhotographicFilm;

@RequiredArgsConstructor
public class PhotographicFilmUpdate extends UpdateValue.Update<PhotographicFilm> {
    private final PhotographicFilm update;

    @Override
    public PhotographicFilm apply(PhotographicFilm original) {
        if (original == null) {
            original = new PhotographicFilm();
        }
        original.setBrand(update.getBrand());
        original.setModel(update.getModel());
        original.setColour(update.getColour());
        original.setExposuresCount(update.getExposuresCount());
        original.setIso(update.getIso());
        original.setFormat(update.getFormat());
        return original;
    }

}
