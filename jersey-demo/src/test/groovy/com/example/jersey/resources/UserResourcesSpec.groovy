package com.example.jersey.resources

import com.example.jersey.resrouces.UserResource
import spock.lang.Specification

class UserResourcesSpec extends Specification {
    def 'DUMMY_PERSON should be defined'() {
        expect:
        UserResource.DUMMY_USER.toJson() != null
    }
}
