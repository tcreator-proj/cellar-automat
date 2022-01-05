package ru.tcreator.cellar_authomat.repository;

import com.beust.jcommander.Parameter;
import lombok.*;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.stereotype.Repository;
import ru.tcreator.cellar_authomat.utills.Delay;
import ru.tcreator.cellar_authomat.utills.FieldSize;
import ru.tcreator.cellar_authomat.utills.HowMuchAround;

/**
 * Хранилище поля на отрисовку
 */
@Getter
@Setter
@ShellComponent
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StateKeeper {
//    @Parameter(
//            names = {"--size", "-S"},
//            description = "Set field size (30x30 in default)"
//    )
    private FieldSize fieldSize;

//    @Parameter(
//            names = {"--cells_alive", "-C"},
//            description = "Choose how many cells in the environment will revive the cell (3 in default)"
//    )
    private HowMuchAround howMuchAround;

//    @Parameter(
//            names = {"--delay", "-D"},
//            description = "Delay between field renderings(`Moderato` or 1s in default)"
//    )
    private Delay delay;

}
