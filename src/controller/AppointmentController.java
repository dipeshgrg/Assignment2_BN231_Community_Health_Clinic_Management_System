package controller;

import model.Appointment;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class AppointmentController {

    private List<Appointment> appointments;

    public AppointmentController() {
        appointments = new ArrayList<>();
    }

    public void scheduleAppointment(Appointment appointment) {
        if (appointment != null) {
            appointments.add(appointment);
        }
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public Appointment searchAppointment(int appointmentId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId() == appointmentId) {
                return appointment;
            }
        }
        return null;
    }

    public void sortAppointmentsByDate() {
        appointments.sort(
                Comparator.comparing(Appointment::getDate)
        );
    }

    public boolean updateAppointmentStatus(int appointmentId, String status) {
        Appointment appointment = searchAppointment(appointmentId);

        if (appointment != null) {
            appointment.updateStatus(status);
            return true;
        }

        return false;
    }

    public boolean cancelAppointment(int appointmentId) {
        Appointment appointment = searchAppointment(appointmentId);

        if (appointment != null) {
            appointment.updateStatus("Cancelled");
            return true;
        }

        return false;
    }
}