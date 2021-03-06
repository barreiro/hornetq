/*
 * Copyright 2009 Red Hat, Inc.
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package org.hornetq.core.server.group.impl;

import java.io.Serializable;

import org.hornetq.api.core.SimpleString;

/**
 * A remote Grouping handler configuration
 *
 * @author <a href="mailto:andy.taylor@jboss.org">Andy Taylor</a>
 */
public final class GroupingHandlerConfiguration implements Serializable
{
   private static final long serialVersionUID = -4600283023652477326L;

   private final SimpleString name;

   private final TYPE type;

   private final SimpleString address;

   private final long timeout;

   public static final int DEFAULT_TIMEOUT = 5000;

   public GroupingHandlerConfiguration(final SimpleString name, final TYPE type, final SimpleString address)
   {
      this(name, type, address, GroupingHandlerConfiguration.DEFAULT_TIMEOUT);
   }

   public GroupingHandlerConfiguration(final SimpleString name,
                                       final TYPE type,
                                       final SimpleString address,
                                       final int timeout)
   {
      this.type = type;
      this.name = name;
      this.address = address;
      this.timeout = timeout;
   }

   public SimpleString getName()
   {
      return name;
   }

   public TYPE getType()
   {
      return type;
   }

   public SimpleString getAddress()
   {
      return address;
   }

   public long getTimeout()
   {
      return timeout;
   }

   public enum TYPE
   {
      LOCAL("LOCAL"), REMOTE("REMOTE");

      private String type;

      TYPE(final String type)
      {
         this.type = type;
      }

      public String getType()
      {
         return type;
      }
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((address == null) ? 0 : address.hashCode());
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      result = prime * result + (int) (timeout ^ (timeout >>> 32));
      result = prime * result + ((type == null) ? 0 : type.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      GroupingHandlerConfiguration other = (GroupingHandlerConfiguration)obj;
      if (address == null)
      {
         if (other.address != null)
            return false;
      }
      else if (!address.equals(other.address))
         return false;
      if (name == null)
      {
         if (other.name != null)
            return false;
      }
      else if (!name.equals(other.name))
         return false;
      if (timeout != other.timeout)
         return false;
      if (type != other.type)
         return false;
      return true;
   }
}
