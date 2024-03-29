package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimbSubsystem;

public class RetractLeft extends Command {
    private ClimbSubsystem sys;
    public RetractLeft(ClimbSubsystem system) {
        sys = system;
    }
    
    @Override
    public void execute() {
        sys.retractLeft();
    }

    @Override
  public void end(boolean interrupted) {
    sys.leftClimb.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }


}
