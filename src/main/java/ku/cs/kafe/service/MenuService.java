//Kantapat Radchawatr 6310450433
package ku.cs.kafe.service;

import ku.cs.kafe.entity.Category;
import ku.cs.kafe.entity.Menu;
import ku.cs.kafe.model.MenuRequest;
import ku.cs.kafe.repository.CategoryRepository;
import ku.cs.kafe.repository.MenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.awt.SystemColor.menu;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getOneById(UUID id){
        return menuRepository.findById(id).get();
    }

    public void createMenu(MenuRequest menu){
        Menu record = modelMapper.map(menu, Menu.class);
        Category category = categoryRepository.findById(menu.getCategoryId()).get();
        record.setCategory(category);
        menuRepository.save(record);
    }
}
