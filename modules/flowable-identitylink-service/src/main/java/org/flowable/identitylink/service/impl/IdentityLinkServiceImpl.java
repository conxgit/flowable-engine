/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flowable.identitylink.service.impl;

import java.util.Collection;
import java.util.List;

import org.flowable.identitylink.service.IdentityLinkService;
import org.flowable.identitylink.service.IdentityLinkServiceConfiguration;
import org.flowable.identitylink.service.impl.persistence.entity.IdentityLinkEntity;

/**
 * @author Tijs Rademakers
 */
public class IdentityLinkServiceImpl extends ServiceImpl implements IdentityLinkService {

    public IdentityLinkServiceImpl() {

    }

    public IdentityLinkServiceImpl(IdentityLinkServiceConfiguration identityLinkServiceConfiguration) {
        super(identityLinkServiceConfiguration);
    }
    
    @Override
    public IdentityLinkEntity getIdentityLink(String id) {
        return getIdentityLinkEntityManager().findById(id);
    }
    
    @Override
    public List<IdentityLinkEntity> findIdentityLinksByTaskId(String taskId) {
        return getIdentityLinkEntityManager().findIdentityLinksByTaskId(taskId);
    }
    
    @Override
    public List<IdentityLinkEntity> findIdentityLinksByProcessInstanceId(String processInstanceId) {
        return getIdentityLinkEntityManager().findIdentityLinksByProcessInstanceId(processInstanceId);
    }
    
    @Override
    public List<IdentityLinkEntity> findIdentityLinksByProcessDefinitionId(String processDefinitionId) {
        return getIdentityLinkEntityManager().findIdentityLinksByProcessDefinitionId(processDefinitionId);
    }
    
    @Override
    public IdentityLinkEntity addCandidateUser(String taskId, String userId) {
        return getIdentityLinkEntityManager().addCandidateUser(taskId, userId);
    }
    
    @Override
    public List<IdentityLinkEntity> addCandidateUsers(String taskId, Collection<String> candidateUsers) {
        return getIdentityLinkEntityManager().addCandidateUsers(taskId, candidateUsers);
    }
    
    @Override
    public IdentityLinkEntity addCandidateGroup(String taskId, String groupId) {
        return getIdentityLinkEntityManager().addCandidateGroup(taskId, groupId);
    }
    
    @Override
    public List<IdentityLinkEntity> addCandidateGroups(String taskId, Collection<String> candidateGroups) {
        return getIdentityLinkEntityManager().addCandidateGroups(taskId, candidateGroups);
    }
    
    @Override
    public IdentityLinkEntity createProcessInstanceIdentityLink(String processInstanceId, String userId, String groupId, String type) {
        return getIdentityLinkEntityManager().addProcessInstanceIdentityLink(processInstanceId, userId, groupId, type);
    }
    
    @Override
    public IdentityLinkEntity createTaskIdentityLink(String taskId, String userId, String groupId, String type) {
        return getIdentityLinkEntityManager().addTaskIdentityLink(taskId, userId, groupId, type);
    }
    
    @Override
    public IdentityLinkEntity createProcessDefinitionIdentityLink(String processDefinitionId, String userId, String groupId) {
        return getIdentityLinkEntityManager().addProcessDefinitionIdentityLink(processDefinitionId, userId, groupId);
    }
    
    @Override
    public IdentityLinkEntity createIdentityLink() {
        return getIdentityLinkEntityManager().create();
    }
    
    @Override
    public void insertIdentityLink(IdentityLinkEntity identityLink) {
        getIdentityLinkEntityManager().insert(identityLink);
    }
    
    @Override
    public void deleteIdentityLink(IdentityLinkEntity identityLink) {
        getIdentityLinkEntityManager().delete(identityLink);
    }
    
    @Override
    public List<IdentityLinkEntity> deleteProcessInstanceIdentityLink(String processInstanceId, String userId, String groupId, String type) {
        return getIdentityLinkEntityManager().deleteProcessInstanceIdentityLink(processInstanceId, userId, groupId, type);
    }
    
    @Override
    public List<IdentityLinkEntity> deleteTaskIdentityLink(String taskId, List<IdentityLinkEntity> currentIdentityLinks, String userId, String groupId, String type) {
        return getIdentityLinkEntityManager().deleteTaskIdentityLink(taskId, currentIdentityLinks, userId, groupId, type);
    }
    
    @Override
    public List<IdentityLinkEntity> deleteProcessDefinitionIdentityLink(String processDefinitionId, String userId, String groupId) {
        return getIdentityLinkEntityManager().deleteProcessDefinitionIdentityLink(processDefinitionId, userId, groupId);
    }
    
    @Override
    public List<IdentityLinkEntity> deleteIdentityLinksByTaskId(String taskId) {
        return getIdentityLinkEntityManager().deleteIdentityLinksByTaskId(taskId);
    }
    
    @Override
    public void deleteIdentityLinksByProcessDefinitionId(String processDefinitionId) {
        getIdentityLinkEntityManager().deleteIdentityLinksByProcDef(processDefinitionId);
    }
}
