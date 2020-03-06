/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.slutprojektbackend.beans;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import nu.te4.slutprojektbackend.ConnectionFactory;
import nu.te4.slutprojektbackend.entities.Instruction;

/**
 *
 * @author Johan
 */
@Stateless
public class InstructionsBean {
    
    public List<Instruction> getInstruction(int id) {
       List<Instruction> instruction = new ArrayList<>();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement("SELECT * FROM instructions_steps WHERE recipe_id = ?");
            preparedstatement.setInt(1, id);
            preparedstatement.executeQuery();
            ResultSet data = preparedstatement.executeQuery();
            
            while (data.next()) {
                String description = data.getString("description");
                int instruction_id = data.getInt("id");
                int recipe_id = data.getInt("recipe_id");
                int stepNumber = data.getInt("step_number");
                Instruction instruct = new Instruction(description, instruction_id ,recipe_id ,stepNumber );
                instruction.add(instruct);
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
        System.out.println(instruction);
        return instruction;
    }

}
