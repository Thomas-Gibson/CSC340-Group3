package csc340.group3.ShowHunter.provider.merchandise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import csc340.group3.ShowHunter.provider.shows.ShowsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MerchandiseService {

    @Autowired
    private MerchandiseRepository merchandiseRepository;
    @Autowired
    private ShowsRepository showsRepository;


    public List<Merchandise> getAllMerch(){
        return merchandiseRepository.findAll();
    }

    public Merchandise getMerchById(int id){
        return merchandiseRepository.findById(id).orElse(null);
    }

    public void addMerch(Merchandise merch){
        merchandiseRepository.save(merch);
    }

    public void updateMerch(int id, Merchandise merch){
        Merchandise existing = getMerchById(id);
        merchandiseRepository.save(merch);
    }

    public void deleteMerch(int id){
        merchandiseRepository.deleteById(id);
    }
}
