package org.usfirst.frc.team5461.robot.triggers;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SimultaneousJoystickButton extends Button {

    private final GenericHID m_joystick;
    private final Set<Integer> m_buttonNumbers;

    @SuppressWarnings("unchecked")
    public SimultaneousJoystickButton(GenericHID joystick, int... buttonNumbers) {
        m_joystick = joystick;
        m_buttonNumbers = new HashSet();
        for (int i : buttonNumbers) {
            m_buttonNumbers.add(i);
        }
    }

    @Override
    public boolean get() {
        boolean allPressed = true;
        for (int buttonNumber : m_buttonNumbers) {
            boolean isPressed = m_joystick.getRawButton(buttonNumber);
            allPressed &= isPressed;
        }
        return allPressed;
    }
}
