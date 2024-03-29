package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimbSubsystem;

public class RetractRight extends Command {

    private ClimbSubsystem sys;
    public RetractRight(ClimbSubsystem system) {
        sys = system;
    }
    
    @Override
    public void execute() {
        sys.retractRight();
    }

    @Override
  public void end(boolean interrupted) {
    sys.rightClimb.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
