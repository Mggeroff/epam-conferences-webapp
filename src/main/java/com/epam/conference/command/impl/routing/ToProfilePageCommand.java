package com.epam.conference.command.impl.routing;

import com.epam.conference.command.Command;
import com.epam.conference.controller.Router;
import com.epam.conference.entity.ParticipantData;
import com.epam.conference.entity.Person;
import com.epam.conference.exception.ServiceException;
import com.epam.conference.service.ParticipantService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ToProfilePageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String page;

        HttpSession session = request.getSession();
        int participantId = Integer.parseInt(session.getAttribute("personId").toString());

        ParticipantService participantService = new ParticipantService();

        Person participant = new Person();
        ParticipantData participantData = new ParticipantData();

        try {
            participant = participantService.findParticipant(participantId);
            participantData = participantService.findParticipantData(participantId);
            page = Router.PAGE_PROFILE;
        } catch (ServiceException e) {
            request.setAttribute("error", e);
            page = Router.PAGE_ERROR;
        }

        request.getSession().setAttribute("participantInfo", participant);
        request.getSession().setAttribute("participantData", participantData);

        return page;
    }
}
