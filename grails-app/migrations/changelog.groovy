/**
 * Initial Changelog from 28. January 2016
 * Assumes, that no database is installed yet.
 * Command: grails dbm-generate-gorm-changelog changelog.groovy
 */

databaseChangeLog = {

    changeSet(author: "schmitza (generated)", id: "1453973248289-1") {
        createTable(tableName: "address") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "addressPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "city", type: "VARCHAR(255)")

            column(name: "country", type: "VARCHAR(255)")

            column(name: "county", type: "VARCHAR(255)")

            column(name: "street_one", type: "VARCHAR(255)")

            column(name: "street_two", type: "VARCHAR(255)")

            column(name: "zip", type: "VARCHAR(255)")
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-2") {
        createTable(tableName: "audit_log") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "audit_logPK")
            }

            column(name: "actor", type: "VARCHAR(255)")

            column(name: "class_name", type: "VARCHAR(255)")

            column(name: "date_created", type: "timestamp") {
                constraints(nullable: "false")
            }

            column(name: "event_name", type: "VARCHAR(255)")

            column(name: "last_updated", type: "timestamp") {
                constraints(nullable: "false")
            }

            column(name: "new_value", type: "VARCHAR(3000)")

            column(name: "old_value", type: "VARCHAR(3000)")

            column(name: "persisted_object_id", type: "VARCHAR(255)")

            column(name: "persisted_object_version", type: "BIGINT")

            column(name: "property_name", type: "VARCHAR(255)")

            column(name: "uri", type: "VARCHAR(255)")
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-3") {
        createTable(tableName: "computer") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "computerPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "computer_name", type: "VARCHAR(50)") {
                constraints(nullable: "false")
            }

            column(name: "computer_vendor_id", type: "BIGINT")
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-4") {
        createTable(tableName: "computer_installed_software") {
            column(name: "computer_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "software_id", type: "BIGINT")
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-5") {
        createTable(tableName: "computer_role") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "computer_rolePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "role", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-6") {
        createTable(tableName: "computer_role_computer") {
            column(name: "computer_role_computer_id", type: "BIGINT")

            column(name: "computer_id", type: "BIGINT")
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-7") {
        createTable(tableName: "connection_type") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "connection_typePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "connection", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-8") {
        createTable(tableName: "data_category") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "data_categoryPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "category", type: "VARCHAR(255)")
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-9") {
        createTable(tableName: "department") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "departmentPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "department_name", type: "VARCHAR(60)") {
                constraints(nullable: "false")
            }

            column(name: "supervisor_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-10") {
        createTable(tableName: "location") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "locationPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "computer_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "location_building", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "location_level", type: "VARCHAR(6)") {
                constraints(nullable: "false")
            }

            column(name: "location_room", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "unit_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-11") {
        createTable(tableName: "module_type") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "module_typePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "module_type", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-12") {
        createTable(tableName: "person") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "personPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "email", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "first_name", type: "VARCHAR(40)") {
                constraints(nullable: "false")
            }

            column(name: "last_name", type: "VARCHAR(40)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-13") {
        createTable(tableName: "person_process_owner_system") {
            column(name: "system_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "person_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-14") {
        createTable(tableName: "person_system_owner_system") {
            column(name: "system_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "person_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-15") {
        createTable(tableName: "qualifiable_object") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "qualifiable_objectPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "class", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "calib_interval", type: "INT")

            column(name: "calib_period", type: "VARCHAR(5)")

            column(name: "is_active", type: "BOOLEAN")

            column(name: "last_calibration", type: "timestamp")

            column(name: "module_connection_id", type: "BIGINT")

            column(name: "module_firmware", type: "VARCHAR(255)")

            column(name: "module_model", type: "VARCHAR(255)")

            column(name: "module_name", type: "VARCHAR(255)")

            column(name: "module_serial", type: "VARCHAR(255)")

            column(name: "module_type_id", type: "BIGINT")

            column(name: "module_vendor_id", type: "BIGINT")

            column(name: "needs_calibration", type: "BOOLEAN")

            column(name: "next_calibration", type: "timestamp")

            column(name: "productive_date", type: "timestamp")

            column(name: "retirement_date", type: "timestamp")

            column(name: "unit_id", type: "BIGINT")

            column(name: "software_iq_oq", type: "VARCHAR(255)")

            column(name: "software_name", type: "VARCHAR(50)")

            column(name: "software_vendor_id", type: "BIGINT")

            column(name: "software_version", type: "VARCHAR(255)")
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-16") {
        createTable(tableName: "qualification") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "qualificationPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "attachment", type: "BINARY(255)")

            column(name: "comment", type: "VARCHAR(1000)")

            column(name: "qualification_date", type: "timestamp") {
                constraints(nullable: "false")
            }

            column(name: "qualification_object_id", type: "BIGINT")

            column(name: "qualification_type_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-17") {
        createTable(tableName: "qualification_type") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "qualification_typePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "type", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-18") {
        createTable(tableName: "role") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "rolePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "authority", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-19") {
        createTable(tableName: "role_group") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "role_groupPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "display_string", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-20") {
        createTable(tableName: "role_group_role") {
            column(name: "role_group_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "role_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-21") {
        createTable(tableName: "system") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "systemPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "area", type: "VARCHAR(3)") {
                constraints(nullable: "false")
            }

            column(name: "data_flow", type: "BLOB")

            column(name: "is_active", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "retirement_date", type: "timestamp")

            column(name: "system_data_category_id", type: "BIGINT")

            column(name: "system_department_id", type: "BIGINT")

            column(name: "system_name", type: "VARCHAR(50)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-22") {
        createTable(tableName: "system_role") {
            column(name: "system_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "computer_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "computer_role_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-23") {
        createTable(tableName: "system_uses_software") {
            column(name: "system_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "software_id", type: "BIGINT")
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-24") {
        createTable(tableName: "unit") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "unitPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "system_id", type: "BIGINT")

            column(name: "unit_name", type: "VARCHAR(50)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-25") {
        createTable(tableName: "user") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "userPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "account_expired", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "account_locked", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "enabled", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "false_password_count", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "password", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "password_change_date", type: "timestamp")

            column(name: "password_expired", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "person_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "signature", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "username", type: "VARCHAR(25)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-26") {
        createTable(tableName: "user_role") {
            column(name: "user_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "role_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-27") {
        createTable(tableName: "user_role_group") {
            column(name: "role_group_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-28") {
        createTable(tableName: "vendor") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "vendorPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "address_id", type: "BIGINT")

            column(name: "email_one", type: "VARCHAR(255)")

            column(name: "email_two", type: "VARCHAR(255)")

            column(name: "fax", type: "VARCHAR(255)")

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "phone_one", type: "VARCHAR(255)")

            column(name: "phone_two", type: "VARCHAR(255)")

            column(name: "url_one", type: "VARCHAR(255)")

            column(name: "url_two", type: "VARCHAR(255)")
        }
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-29") {
        addPrimaryKey(columnNames: "person_id, system_id", tableName: "person_process_owner_system")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-30") {
        addPrimaryKey(columnNames: "person_id, system_id", tableName: "person_system_owner_system")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-31") {
        addPrimaryKey(columnNames: "role_group_id, role_id", constraintName: "role_group_rolePK", tableName: "role_group_role")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-32") {
        addPrimaryKey(columnNames: "system_id, computer_id, computer_role_id", constraintName: "system_rolePK", tableName: "system_role")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-33") {
        addPrimaryKey(columnNames: "user_id, role_id", constraintName: "user_rolePK", tableName: "user_role")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-34") {
        addPrimaryKey(columnNames: "role_group_id, user_id", constraintName: "user_role_groupPK", tableName: "user_role_group")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-35") {
        addUniqueConstraint(columnNames: "computer_name", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "computer")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-36") {
        addUniqueConstraint(columnNames: "role", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "computer_role")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-37") {
        addUniqueConstraint(columnNames: "connection", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "connection_type")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-38") {
        addUniqueConstraint(columnNames: "category", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "data_category")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-39") {
        addUniqueConstraint(columnNames: "supervisor_id", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "department")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-40") {
        addUniqueConstraint(columnNames: "computer_id", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "location")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-41") {
        addUniqueConstraint(columnNames: "unit_id", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "location")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-42") {
        addUniqueConstraint(columnNames: "module_type", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "module_type")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-43") {
        addUniqueConstraint(columnNames: "module_serial", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "qualifiable_object")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-44") {
        addUniqueConstraint(columnNames: "type", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "qualification_type")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-45") {
        addUniqueConstraint(columnNames: "authority", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "role")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-46") {
        addUniqueConstraint(columnNames: "name", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "role_group")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-47") {
        addUniqueConstraint(columnNames: "unit_name", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "unit")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-48") {
        addUniqueConstraint(columnNames: "person_id", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "user")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-49") {
        addUniqueConstraint(columnNames: "username", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "user")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-50") {
        addUniqueConstraint(columnNames: "address_id", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "vendor")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-51") {
        addForeignKeyConstraint(baseColumnNames: "computer_id", baseTableName: "system_role", constraintName: "FK_2l4l6dfna8p5unxnud5ks6d6s", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "computer")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-52") {
        addForeignKeyConstraint(baseColumnNames: "computer_vendor_id", baseTableName: "computer", constraintName: "FK_31jr97alvhyh0im1w795n8nxh", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "vendor")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-53") {
        addForeignKeyConstraint(baseColumnNames: "address_id", baseTableName: "vendor", constraintName: "FK_56kv9t1acwl2hn1e0extuqpxu", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "address")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-54") {
        addForeignKeyConstraint(baseColumnNames: "computer_role_id", baseTableName: "system_role", constraintName: "FK_6iayqfhp1nka56kfu1qju6av7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "computer_role")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-55") {
        addForeignKeyConstraint(baseColumnNames: "software_vendor_id", baseTableName: "qualifiable_object", constraintName: "FK_7qy4k4xh829902oueea7exlqy", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "vendor")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-56") {
        addForeignKeyConstraint(baseColumnNames: "module_type_id", baseTableName: "qualifiable_object", constraintName: "FK_7wc868nrh7qlg34kgkgkt6nhj", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "module_type")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-57") {
        addForeignKeyConstraint(baseColumnNames: "qualification_object_id", baseTableName: "qualification", constraintName: "FK_86g4t8xy9p859fc9ow16ulghu", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "qualifiable_object")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-58") {
        addForeignKeyConstraint(baseColumnNames: "computer_id", baseTableName: "location", constraintName: "FK_94kjh4hqvtukcblwaqsrthp0g", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "computer")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-59") {
        addForeignKeyConstraint(baseColumnNames: "role_group_id", baseTableName: "user_role_group", constraintName: "FK_9se04wabb1vif6yjcfged3s2p", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role_group")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-60") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK_apcc8lxk2xnug8377fatvbn04", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-61") {
        addForeignKeyConstraint(baseColumnNames: "supervisor_id", baseTableName: "department", constraintName: "FK_argkildrrkmhx6qwxsjcrc9f5", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "person")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-62") {
        addForeignKeyConstraint(baseColumnNames: "person_id", baseTableName: "person_process_owner_system", constraintName: "FK_bn4c2ad429368gsnnbdpv5b4a", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "person")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-63") {
        addForeignKeyConstraint(baseColumnNames: "system_id", baseTableName: "person_process_owner_system", constraintName: "FK_c3ow3ap2wu6ivgi5q5vfvr80", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "system")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-64") {
        addForeignKeyConstraint(baseColumnNames: "role_group_id", baseTableName: "role_group_role", constraintName: "FK_cqr9g8iosupkylg4fw10paumq", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role_group")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-65") {
        addForeignKeyConstraint(baseColumnNames: "system_department_id", baseTableName: "system", constraintName: "FK_d3pw2v6xdpamr5dkwwuvdi03e", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "department")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-66") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role_group", constraintName: "FK_d9ttuc99ggo3nld2pd96x6pe7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-67") {
        addForeignKeyConstraint(baseColumnNames: "system_id", baseTableName: "system_uses_software", constraintName: "FK_dj7jcee7uy1s44wuhj8l0xfs8", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "system")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-68") {
        addForeignKeyConstraint(baseColumnNames: "system_id", baseTableName: "unit", constraintName: "FK_dv9p4a4n3jb7kdrx3x4wji7nf", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "system")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-69") {
        addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "role_group_role", constraintName: "FK_dxc3snhixkg9qn3c46p6hyjli", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-70") {
        addForeignKeyConstraint(baseColumnNames: "system_id", baseTableName: "system_role", constraintName: "FK_e8toe28d4dtlo0eaf0rdsaojh", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "system")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-71") {
        addForeignKeyConstraint(baseColumnNames: "system_id", baseTableName: "person_system_owner_system", constraintName: "FK_fbaq1d94bgkampt1vw9ui8ikp", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "system")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-72") {
        addForeignKeyConstraint(baseColumnNames: "software_id", baseTableName: "system_uses_software", constraintName: "FK_fqa967ggssrxwvtwart0wruns", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "qualifiable_object")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-73") {
        addForeignKeyConstraint(baseColumnNames: "module_connection_id", baseTableName: "qualifiable_object", constraintName: "FK_gdcty2qkjv3ebyhtyoxui53fk", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "connection_type")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-74") {
        addForeignKeyConstraint(baseColumnNames: "qualification_type_id", baseTableName: "qualification", constraintName: "FK_hh7a7dajdheryen21ksucl2c", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "qualification_type")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-75") {
        addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK_it77eq964jhfqtu54081ebtio", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-76") {
        addForeignKeyConstraint(baseColumnNames: "system_data_category_id", baseTableName: "system", constraintName: "FK_kmgxirn1lfkr7hlob962d3lqx", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "data_category")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-77") {
        addForeignKeyConstraint(baseColumnNames: "software_id", baseTableName: "computer_installed_software", constraintName: "FK_l4akkjiy7uhitx2o3degp6oas", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "qualifiable_object")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-78") {
        addForeignKeyConstraint(baseColumnNames: "person_id", baseTableName: "person_system_owner_system", constraintName: "FK_l748wxev3vhrlpuhnflh8s6od", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "person")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-79") {
        addForeignKeyConstraint(baseColumnNames: "unit_id", baseTableName: "location", constraintName: "FK_mi2ksdb0indk21uqo09cbl2yy", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "unit")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-80") {
        addForeignKeyConstraint(baseColumnNames: "computer_role_computer_id", baseTableName: "computer_role_computer", constraintName: "FK_mso6ob9yaepvnjd13akhsh4gg", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "computer_role")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-81") {
        addForeignKeyConstraint(baseColumnNames: "unit_id", baseTableName: "qualifiable_object", constraintName: "FK_nxgcw85rw3x822aebje99k0pn", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "unit")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-82") {
        addForeignKeyConstraint(baseColumnNames: "module_vendor_id", baseTableName: "qualifiable_object", constraintName: "FK_ojwgwdj4o5f3o20tmd2xyen5h", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "vendor")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-83") {
        addForeignKeyConstraint(baseColumnNames: "computer_id", baseTableName: "computer_role_computer", constraintName: "FK_p2399rpatjv8d1bbssg7h5v94", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "computer")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-84") {
        addForeignKeyConstraint(baseColumnNames: "person_id", baseTableName: "user", constraintName: "FK_skugu4aa786hx4o05wn6cs7q0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "person")
    }

    changeSet(author: "schmitza (generated)", id: "1453973248289-85") {
        addForeignKeyConstraint(baseColumnNames: "computer_id", baseTableName: "computer_installed_software", constraintName: "FK_sxcccum51hb5km4b5dwxgj34b", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "computer")
    }
}
