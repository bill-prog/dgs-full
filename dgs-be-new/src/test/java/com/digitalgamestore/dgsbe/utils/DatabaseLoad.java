package com.digitalgamestore.dgsbe.utils;

import com.digitalgamestore.dgsbe.model.Kategorija;
import com.digitalgamestore.dgsbe.model.Korisnik;
import com.digitalgamestore.dgsbe.model.Proizvodac;
import com.digitalgamestore.dgsbe.model.Uloga;
import com.digitalgamestore.dgsbe.repository.KategorijaRepository;
import com.digitalgamestore.dgsbe.repository.KorisnikRepository;
import com.digitalgamestore.dgsbe.repository.ProizvodacRepository;
import com.digitalgamestore.dgsbe.repository.UlogaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DatabaseLoad {

    @Autowired
    private KategorijaRepository kategorijaRepository;



    @Autowired
    private ProizvodacRepository proizvodacRepository;

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private UlogaRepository ulogaRepository;


    public List<Kategorija> createKategorijas() {
        List<Kategorija> list = new ArrayList<>();

        Uloga uloga = new Uloga();
        uloga.setNazivUloga("ADMIN");
        uloga = ulogaRepository.save(uloga);

        Korisnik korisnik = new Korisnik();
        korisnik.setEmailAdresa("email@gmail.com");
        korisnik.setLozinka(12345);
        korisnik.setUloga(uloga);
        korisnik.setKorisnickoIme("adminko");

        korisnik = korisnikRepository.save(korisnik);

        Kategorija k1 = new Kategorija();
        k1.setOpisKategorije("opis1");
        k1.setAdmin(korisnik);
        k1.setNazivKategorije("naziv1");

        Kategorija k2 = new Kategorija();
        k2.setOpisKategorije("opis2");
        k2.setAdmin(korisnik);
        k2.setNazivKategorije("naziv2");

        list.add(kategorijaRepository.save(k1));
        list.add(kategorijaRepository.save(k2));

        return list;
    }

    public List<Proizvodac> createProizvodacs() {

        Date date = new Date();
        date.setYear(2000);
        date.setMonth(5);

        List<Proizvodac> list = new ArrayList<>();


        Proizvodac k1 = new Proizvodac();
        k1.setGodOsnutka(date);
        k1.setNazivProizvodac("Ubisoft");

        Proizvodac k2 = new Proizvodac();
        k2.setGodOsnutka(date);
        k2.setNazivProizvodac("Microsoft");

        list.add(proizvodacRepository.save(k1));
        list.add(proizvodacRepository.save(k2));

        return list;
    }

    public Korisnik createAdmin() {

        Uloga uloga = new Uloga();
        uloga.setNazivUloga("ADMIN");
        uloga = ulogaRepository.save(uloga);

        Korisnik korisnik = new Korisnik();
        korisnik.setEmailAdresa("email@gmail.com");
        korisnik.setLozinka(12345);
        korisnik.setUloga(uloga);
        korisnik.setKorisnickoIme("adminko");

        korisnik = korisnikRepository.save(korisnik);

        return korisnik;
    }

    public KategorijaRepository getKategorijaRepository() {
        return kategorijaRepository;
    }

    public KorisnikRepository getKorisnikRepository() {
        return korisnikRepository;
    }

    public UlogaRepository getUlogaRepository() {
        return ulogaRepository;
    }
    public ProizvodacRepository getProizvodacRepository() {
        return proizvodacRepository;
    }
}
