package csc340.group3.ShowHunter.provider.merchandise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/merch")
public class MerchandiseController {

    @Autowired
    private MerchandiseService merchandiseService;

    @GetMapping("/all")
    public List<Merchandise> getAllMerch(){
        return merchandiseService.getAllMerch();
    }

    @GetMapping("/{id}")
    public Optional<Merchandise> getMerch(@PathVariable int id){
        return merchandiseService.getMerchById(id);
    }

    @PostMapping("/new")
    public List<Merchandise> addMerch(@RequestBody Merchandise merch){
        merchandiseService.addMerch(merch);
        return merchandiseService.getAllMerch();
    }

    @PutMapping("update/{id}")
    public Optional<Merchandise> updateMerch(@PathVariable int id, @RequestBody Merchandise merch){
        merchandiseService.updateMerch(id, merch);
        return merchandiseService.getMerchById(id);
    }

    @DeleteMapping("delete/{id}")
    public List<Merchandise> deleteMerchById(@PathVariable int id){
        merchandiseService.deleteMerch(id);
        return merchandiseService.getAllMerch();
    }
}
