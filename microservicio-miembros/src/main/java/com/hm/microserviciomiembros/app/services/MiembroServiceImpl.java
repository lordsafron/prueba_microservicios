package com.hm.microserviciomiembros.app.services;

import org.springframework.stereotype.Service;

import com.hm.commonscapas.services.CommonServiceImpl;
import com.hm.commonsmiembros.models.entity.Miembro;
import com.hm.microserviciomiembros.app.models.repository.MiembroRepository;
/**
 * @author: Hugo Miguel Martinez Hernandez
 * @see <a href = "https://www.youtube.com/channel/UC52UbfusfkWETo6ydpvnFnw?view_as=subscriber" /> youtube.com – Mi canal de proyecyo personal </a>
 */
@Service
public class MiembroServiceImpl extends CommonServiceImpl<Miembro, MiembroRepository> implements MiembroService {

}
