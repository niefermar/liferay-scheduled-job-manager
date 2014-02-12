/*
 * Copyright (C) 2005-2014 Rivet Logic Corporation.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; version 3 of the License.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

package com.rivetlogic.quartz.sort;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rivetlogic.quartz.bean.SchedulerJobBean;

/**
 * @author steven.barba
 * 
 */
public class JobNameComparator extends OrderByComparator {
    
    private static final long serialVersionUID = 5419351872248414916L;
    
    private boolean asc;
    
    public JobNameComparator() {
        this(false);
    }
    
    public JobNameComparator(boolean asc) {
        this.asc = asc;
    }
    
    @Override
    public int compare(Object arg0, Object arg1) {
        SchedulerJobBean jobBean0 = (SchedulerJobBean) arg0;
        SchedulerJobBean jobBean1 = (SchedulerJobBean) arg1;
        
        int value = jobBean0.getShortName().toLowerCase().compareTo(jobBean1.getShortName().toLowerCase());
        
        if (asc) {
            return value;
        } else {
            return -value;
        }
    }
    
}
