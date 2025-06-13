/*
 * AppOps is a Java framework to develop, deploy microservices with ease and is available for free
 * and common use developed by AinoSoft ( www.ainosoft.com )
 *
 * AppOps and AinoSoft are registered trademarks of Aino Softwares private limited, India.
 *
 * Copyright (C) <2016> <Aino Softwares private limited>
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version along with applicable additional terms as
 * provisioned by GPL 3.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License and applicable additional terms
 * along with this program.
 *
 * If not, see <https://www.gnu.org/licenses/> and <https://www.appops.org/license>
 */

package org.appops.teacherapp.slim;

import org.appops.core.annotation.SlimModule;
import org.appops.slim.base.injection.ServiceSlimModule;
import org.appops.teacherapp.core.TeacherService;
import org.appops.teacherapp.store.TeacherStoreApi;


/**
 * A slim module which contains service api related binding.
 * 
 * @author suraj
 *
 */

@SlimModule(serviceName = TeacherService.class)
public class TeacherSlimModule extends ServiceSlimModule {

  @Override
  public void configureModule() {
    bindServiceApi(TeacherStoreApi.class);
  }
}
