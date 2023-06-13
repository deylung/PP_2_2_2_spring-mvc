package web.dao;

import web.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private static List<Car> carList;

    static {
        carList = new ArrayList<>();
        carList.add(new Car("name1", "model1", "color1"));
        carList.add(new Car("name2", "model2", "color2"));
        carList.add(new Car("name3", "model3", "color3"));
        carList.add(new Car("name4", "model4", "color4"));
        carList.add(new Car("name5", "model5", "color5"));
    }

    @Override
    public List<Car> getCars() {
        return carList;
    }

    @Override
    public List<Car> getCarListOnCount(Integer countCars) {
        List<Car> list = getCars();
        if (countCars == null || countCars < 0 || countCars > list.size()) {
            countCars = list.size();
        }
        return list.stream().limit(countCars).toList();
    }
}
