package sr.unasat.designPatterns.decorator;

import sr.unasat.DAO.SidesDAO;
import sr.unasat.config.JPAConfiguration;
import sr.unasat.designPatterns.protoype.Meal;
import sr.unasat.entities.Sides;

public abstract class SideDecorator extends Meal {
   SidesDAO sidesDAO = new SidesDAO(JPAConfiguration.getEntityManager());

   protected String sideName;

   public Sides sideDish(){
      return sidesDAO.findSide(sideName);
   }

   public abstract void displayMeal();

}
