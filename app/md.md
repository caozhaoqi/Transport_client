Configuring logger redirection
Configuring logger redirection
2020-09-03 02:50:32.211 [debug] <0.286.0> Lager installed handler error_logger_lager_h into error_logger
2020-09-03 02:50:32.249 [debug] <0.289.0> Lager installed handler lager_forwarder_backend into error_logger_lager_event
2020-09-03 02:50:32.249 [debug] <0.292.0> Lager installed handler lager_forwarder_backend into rabbit_log_lager_event
2020-09-03 02:50:32.249 [debug] <0.295.0> Lager installed handler lager_forwarder_backend into rabbit_log_channel_lager_event
2020-09-03 02:50:32.249 [debug] <0.298.0> Lager installed handler lager_forwarder_backend into rabbit_log_connection_lager_event
2020-09-03 02:50:32.249 [debug] <0.301.0> Lager installed handler lager_forwarder_backend into rabbit_log_feature_flags_lager_event
2020-09-03 02:50:32.249 [debug] <0.304.0> Lager installed handler lager_forwarder_backend into rabbit_log_federation_lager_event
2020-09-03 02:50:32.249 [debug] <0.307.0> Lager installed handler lager_forwarder_backend into rabbit_log_ldap_lager_event
2020-09-03 02:50:32.249 [debug] <0.310.0> Lager installed handler lager_forwarder_backend into rabbit_log_mirroring_lager_event
2020-09-03 02:50:32.249 [debug] <0.313.0> Lager installed handler lager_forwarder_backend into rabbit_log_prelaunch_lager_event
2020-09-03 02:50:32.249 [debug] <0.316.0> Lager installed handler lager_forwarder_backend into rabbit_log_queue_lager_event
2020-09-03 02:50:32.249 [debug] <0.319.0> Lager installed handler lager_forwarder_backend into rabbit_log_ra_lager_event
2020-09-03 02:50:32.249 [debug] <0.322.0> Lager installed handler lager_forwarder_backend into rabbit_log_shovel_lager_event
2020-09-03 02:50:32.250 [debug] <0.325.0> Lager installed handler lager_forwarder_backend into rabbit_log_upgrade_lager_event
2020-09-03 02:50:32.268 [info] <0.44.0> Application lager started on node rabbit@8ae319d26a5c
2020-09-03 02:50:32.634 [info] <0.44.0> Application mnesia started on node rabbit@8ae319d26a5c
2020-09-03 02:50:32.636 [info] <0.269.0> 
 Starting RabbitMQ 3.8.7 on Erlang 23.0.3
 Copyright (c) 2007-2020 VMware, Inc. or its affiliates.
 Licensed under the MPL 2.0. Website: https://rabbitmq.com
2020-09-03T02:50:32.639056046Z 
  ##  ##      RabbitMQ 3.8.7
  ##  ##
  ##########  Copyright (c) 2007-2020 VMware, Inc. or its affiliates.
  ######  ##
  ##########  Licensed under the MPL 2.0. Website: https://rabbitmq.com
  Doc guides: https://rabbitmq.com/documentation.html
  Support:    https://rabbitmq.com/contact.html
  Tutorials:  https://rabbitmq.com/getstarted.html
  Monitoring: https://rabbitmq.com/monitoring.html
  Logs: <stdout>
  Config file(s): /etc/rabbitmq/rabbitmq.conf
                  /etc/rabbitmq/conf.d/management_agent.disable_metrics_collector.conf
  Starting broker...2020-09-03 02:50:32.642 [info] <0.269.0> 
 node           : rabbit@8ae319d26a5c
 home dir       : /var/lib/rabbitmq
 config file(s) : /etc/rabbitmq/rabbitmq.conf
                : /etc/rabbitmq/conf.d/management_agent.disable_metrics_collector.conf
 cookie hash    : UdJvdBP/qV2ngs8HAy442g==
 log(s)         : <stdout>
 database dir   : /var/lib/rabbitmq/mnesia/rabbit@8ae319d26a5c
2020-09-03 02:50:32.712 [debug] <0.282.0> Lager installed handler lager_backend_throttle into lager_event
2020-09-03 02:50:37.285 [info] <0.269.0> Running boot step pre_boot defined by app rabbit
2020-09-03 02:50:37.285 [info] <0.269.0> Running boot step rabbit_core_metrics defined by app rabbit
2020-09-03 02:50:37.286 [info] <0.269.0> Running boot step rabbit_alarm defined by app rabbit
2020-09-03 02:50:37.293 [info] <0.356.0> Memory high watermark set to 797 MiB (836086988 bytes) of 1993 MiB (2090217472 bytes) total
2020-09-03 02:50:37.305 [info] <0.358.0> Enabling free disk space monitoring
2020-09-03 02:50:37.305 [info] <0.358.0> Disk free limit set to 50MB
2020-09-03 02:50:37.309 [info] <0.269.0> Running boot step code_server_cache defined by app rabbit
2020-09-03 02:50:37.309 [info] <0.269.0> Running boot step file_handle_cache defined by app rabbit
2020-09-03 02:50:37.310 [info] <0.361.0> Limiting to approx 1048479 file handles (943629 sockets)
2020-09-03 02:50:37.310 [info] <0.362.0> FHC read buffering:  OFF
2020-09-03 02:50:37.310 [info] <0.362.0> FHC write buffering: ON
2020-09-03 02:50:37.313 [info] <0.269.0> Running boot step worker_pool defined by app rabbit
2020-09-03 02:50:37.313 [info] <0.345.0> Will use 1 processes for default worker pool
2020-09-03 02:50:37.314 [info] <0.345.0> Starting worker pool 'worker_pool' with 1 processes in it
2020-09-03 02:50:37.315 [info] <0.269.0> Running boot step database defined by app rabbit
2020-09-03 02:50:37.316 [info] <0.269.0> Node database directory at /var/lib/rabbitmq/mnesia/rabbit@8ae319d26a5c is empty. Assuming we need to join an existing cluster or initialise from scratch...
2020-09-03 02:50:37.317 [info] <0.269.0> Configured peer discovery backend: rabbit_peer_discovery_classic_config
2020-09-03 02:50:37.317 [info] <0.269.0> Will try to lock with peer discovery backend rabbit_peer_discovery_classic_config
2020-09-03 02:50:37.317 [info] <0.269.0> Peer discovery backend does not support locking, falling back to randomized delay
2020-09-03 02:50:37.317 [info] <0.269.0> Peer discovery backend rabbit_peer_discovery_classic_config does not support registration, skipping randomized startup delay.
2020-09-03 02:50:37.317 [info] <0.269.0> All discovered existing cluster peers: 
2020-09-03 02:50:37.317 [info] <0.269.0> Discovered no peer nodes to cluster with. Some discovery backends can filter nodes out based on a readiness criteria. Enabling debug logging might help troubleshoot.
2020-09-03 02:50:37.321 [info] <0.44.0> Application mnesia exited with reason: stopped
2020-09-03 02:50:37.321 [info] <0.44.0> Application mnesia exited with reason: stopped
2020-09-03 02:50:37.348 [info] <0.44.0> Application mnesia started on node rabbit@8ae319d26a5c
2020-09-03 02:50:37.469 [info] <0.269.0> Waiting for Mnesia tables for 30000 ms, 9 retries left
2020-09-03 02:50:37.469 [info] <0.269.0> Successfully synced tables from a peer
2020-09-03 02:50:37.484 [info] <0.269.0> Waiting for Mnesia tables for 30000 ms, 9 retries left
2020-09-03 02:50:37.484 [info] <0.269.0> Successfully synced tables from a peer
2020-09-03 02:50:37.484 [info] <0.269.0> Feature flag `implicit_default_bindings`: supported, attempt to enable...
2020-09-03 02:50:37.484 [info] <0.269.0> Feature flag `implicit_default_bindings`: mark as enabled=state_changing
2020-09-03 02:50:37.489 [info] <0.269.0> Feature flags: list of feature flags found:
2020-09-03 02:50:37.490 [info] <0.269.0> Feature flags:   [~] implicit_default_bindings
2020-09-03 02:50:37.490 [info] <0.269.0> Feature flags:   [ ] quorum_queue
2020-09-03 02:50:37.490 [info] <0.269.0> Feature flags:   [ ] virtual_host_metadata
2020-09-03 02:50:37.490 [info] <0.269.0> Feature flags: feature flag states written to disk: yes
2020-09-03 02:50:37.503 [info] <0.269.0> Waiting for Mnesia tables for 30000 ms, 0 retries left
2020-09-03 02:50:37.506 [info] <0.269.0> Successfully synced tables from a peer
2020-09-03 02:50:37.506 [info] <0.269.0> Feature flag `implicit_default_bindings`: mark as enabled=true
2020-09-03 02:50:37.512 [info] <0.269.0> Feature flags: list of feature flags found:
2020-09-03 02:50:37.513 [info] <0.269.0> Feature flags:   [x] implicit_default_bindings
2020-09-03 02:50:37.514 [info] <0.269.0> Feature flags:   [ ] quorum_queue
2020-09-03 02:50:37.514 [info] <0.269.0> Feature flags:   [ ] virtual_host_metadata
2020-09-03 02:50:37.514 [info] <0.269.0> Feature flags: feature flag states written to disk: yes
2020-09-03 02:50:37.526 [info] <0.269.0> Feature flag `quorum_queue`: supported, attempt to enable...
2020-09-03 02:50:37.529 [info] <0.269.0> Feature flag `quorum_queue`: mark as enabled=state_changing
2020-09-03 02:50:37.534 [info] <0.269.0> Feature flags: list of feature flags found:
2020-09-03 02:50:37.535 [info] <0.269.0> Feature flags:   [x] implicit_default_bindings
2020-09-03 02:50:37.535 [info] <0.269.0> Feature flags:   [~] quorum_queue
2020-09-03 02:50:37.535 [info] <0.269.0> Feature flags:   [ ] virtual_host_metadata
2020-09-03 02:50:37.535 [info] <0.269.0> Feature flags: feature flag states written to disk: yes
2020-09-03 02:50:37.546 [info] <0.269.0> Waiting for Mnesia tables for 30000 ms, 9 retries left
2020-09-03 02:50:37.551 [info] <0.269.0> Successfully synced tables from a peer
2020-09-03 02:50:37.552 [info] <0.269.0> Feature flag `quorum_queue`:   migrating Mnesia table rabbit_queue...
2020-09-03 02:50:37.571 [info] <0.269.0> Feature flag `quorum_queue`:   migrating Mnesia table rabbit_durable_queue...
2020-09-03 02:50:37.589 [info] <0.269.0> Feature flag `quorum_queue`:   Mnesia tables migration done
2020-09-03 02:50:37.589 [info] <0.269.0> Feature flag `quorum_queue`: mark as enabled=true
2020-09-03 02:50:37.597 [info] <0.269.0> Feature flags: list of feature flags found:
2020-09-03 02:50:37.597 [info] <0.269.0> Feature flags:   [x] implicit_default_bindings
2020-09-03 02:50:37.598 [info] <0.269.0> Feature flags:   [x] quorum_queue
2020-09-03 02:50:37.599 [info] <0.269.0> Feature flags:   [ ] virtual_host_metadata
2020-09-03 02:50:37.599 [info] <0.269.0> Feature flags: feature flag states written to disk: yes
2020-09-03 02:50:37.610 [info] <0.269.0> Feature flag `virtual_host_metadata`: supported, attempt to enable...
2020-09-03 02:50:37.614 [info] <0.269.0> Feature flag `virtual_host_metadata`: mark as enabled=state_changing
2020-09-03 02:50:37.620 [info] <0.269.0> Feature flags: list of feature flags found:
2020-09-03 02:50:37.621 [info] <0.269.0> Feature flags:   [x] implicit_default_bindings
2020-09-03 02:50:37.621 [info] <0.269.0> Feature flags:   [x] quorum_queue
2020-09-03 02:50:37.621 [info] <0.269.0> Feature flags:   [~] virtual_host_metadata
2020-09-03 02:50:37.621 [info] <0.269.0> Feature flags: feature flag states written to disk: yes
2020-09-03 02:50:37.634 [info] <0.269.0> Waiting for Mnesia tables for 30000 ms, 9 retries left
2020-09-03 02:50:37.637 [info] <0.269.0> Successfully synced tables from a peer
2020-09-03 02:50:37.654 [info] <0.269.0> Feature flag `virtual_host_metadata`: mark as enabled=true
2020-09-03 02:50:37.662 [info] <0.269.0> Feature flags: list of feature flags found:
2020-09-03 02:50:37.662 [info] <0.269.0> Feature flags:   [x] implicit_default_bindings
2020-09-03 02:50:37.662 [info] <0.269.0> Feature flags:   [x] quorum_queue
2020-09-03 02:50:37.663 [info] <0.269.0> Feature flags:   [x] virtual_host_metadata
2020-09-03 02:50:37.664 [info] <0.269.0> Feature flags: feature flag states written to disk: yes
2020-09-03 02:50:37.675 [info] <0.269.0> Waiting for Mnesia tables for 30000 ms, 9 retries left
2020-09-03 02:50:37.678 [info] <0.269.0> Successfully synced tables from a peer
2020-09-03 02:50:37.699 [info] <0.269.0> Waiting for Mnesia tables for 30000 ms, 9 retries left
2020-09-03 02:50:37.700 [info] <0.269.0> Successfully synced tables from a peer
2020-09-03 02:50:37.700 [info] <0.269.0> Peer discovery backend rabbit_peer_discovery_classic_config does not support registration, skipping registration.
2020-09-03 02:50:37.700 [info] <0.269.0> Running boot step database_sync defined by app rabbit
2020-09-03 02:50:37.700 [info] <0.269.0> Running boot step feature_flags defined by app rabbit
2020-09-03 02:50:37.701 [info] <0.269.0> Running boot step codec_correctness_check defined by app rabbit
2020-09-03 02:50:37.702 [info] <0.269.0> Running boot step external_infrastructure defined by app rabbit
2020-09-03 02:50:37.702 [info] <0.269.0> Running boot step rabbit_registry defined by app rabbit
2020-09-03 02:50:37.702 [info] <0.269.0> Running boot step rabbit_auth_mechanism_cr_demo defined by app rabbit
2020-09-03 02:50:37.702 [info] <0.269.0> Running boot step rabbit_queue_location_random defined by app rabbit
2020-09-03 02:50:37.703 [info] <0.269.0> Running boot step rabbit_event defined by app rabbit
2020-09-03 02:50:37.704 [info] <0.269.0> Running boot step rabbit_auth_mechanism_amqplain defined by app rabbit
2020-09-03 02:50:37.704 [info] <0.269.0> Running boot step rabbit_auth_mechanism_plain defined by app rabbit
2020-09-03 02:50:37.705 [info] <0.269.0> Running boot step rabbit_exchange_type_direct defined by app rabbit
2020-09-03 02:50:37.705 [info] <0.269.0> Running boot step rabbit_exchange_type_fanout defined by app rabbit
2020-09-03 02:50:37.706 [info] <0.269.0> Running boot step rabbit_exchange_type_headers defined by app rabbit
2020-09-03 02:50:37.707 [info] <0.269.0> Running boot step rabbit_exchange_type_topic defined by app rabbit
2020-09-03 02:50:37.707 [info] <0.269.0> Running boot step rabbit_mirror_queue_mode_all defined by app rabbit
2020-09-03 02:50:37.707 [info] <0.269.0> Running boot step rabbit_mirror_queue_mode_exactly defined by app rabbit
2020-09-03 02:50:37.708 [info] <0.269.0> Running boot step rabbit_mirror_queue_mode_nodes defined by app rabbit
2020-09-03 02:50:37.709 [info] <0.269.0> Running boot step rabbit_priority_queue defined by app rabbit
2020-09-03 02:50:37.709 [info] <0.269.0> Priority queues enabled, real BQ is rabbit_variable_queue
2020-09-03 02:50:37.709 [info] <0.269.0> Running boot step rabbit_queue_location_client_local defined by app rabbit
2020-09-03 02:50:37.709 [info] <0.269.0> Running boot step rabbit_queue_location_min_masters defined by app rabbit
2020-09-03 02:50:37.709 [info] <0.269.0> Running boot step kernel_ready defined by app rabbit
2020-09-03 02:50:37.709 [info] <0.269.0> Running boot step rabbit_sysmon_minder defined by app rabbit
2020-09-03 02:50:37.711 [info] <0.269.0> Running boot step rabbit_epmd_monitor defined by app rabbit
2020-09-03 02:50:37.712 [info] <0.584.0> epmd monitor knows us, inter-node communication (distribution) port: 25672
2020-09-03 02:50:37.713 [info] <0.269.0> Running boot step guid_generator defined by app rabbit
2020-09-03 02:50:37.717 [info] <0.269.0> Running boot step rabbit_node_monitor defined by app rabbit
2020-09-03 02:50:37.717 [info] <0.588.0> Starting rabbit_node_monitor
2020-09-03 02:50:37.718 [info] <0.269.0> Running boot step delegate_sup defined by app rabbit
2020-09-03 02:50:37.719 [info] <0.269.0> Running boot step rabbit_memory_monitor defined by app rabbit
2020-09-03 02:50:37.720 [info] <0.269.0> Running boot step core_initialized defined by app rabbit
2020-09-03 02:50:37.720 [info] <0.269.0> Running boot step upgrade_queues defined by app rabbit
2020-09-03 02:50:37.734 [info] <0.269.0> message_store upgrades: 1 to apply
2020-09-03 02:50:37.735 [info] <0.269.0> message_store upgrades: Applying rabbit_variable_queue:move_messages_to_vhost_store
2020-09-03 02:50:37.735 [info] <0.269.0> message_store upgrades: No durable queues found. Skipping message store migration
2020-09-03 02:50:37.735 [info] <0.269.0> message_store upgrades: Removing the old message store data
2020-09-03 02:50:37.739 [info] <0.269.0> message_store upgrades: All upgrades applied successfully
2020-09-03 02:50:37.755 [info] <0.269.0> Running boot step rabbit_connection_tracking defined by app rabbit
2020-09-03 02:50:37.755 [info] <0.269.0> Running boot step rabbit_connection_tracking_handler defined by app rabbit
2020-09-03 02:50:37.755 [info] <0.269.0> Running boot step rabbit_exchange_parameters defined by app rabbit
2020-09-03 02:50:37.757 [info] <0.269.0> Running boot step rabbit_mirror_queue_misc defined by app rabbit
2020-09-03 02:50:37.757 [info] <0.269.0> Running boot step rabbit_policies defined by app rabbit
2020-09-03 02:50:37.759 [info] <0.269.0> Running boot step rabbit_policy defined by app rabbit
2020-09-03 02:50:37.759 [info] <0.269.0> Running boot step rabbit_queue_location_validator defined by app rabbit
2020-09-03 02:50:37.759 [info] <0.269.0> Running boot step rabbit_quorum_memory_manager defined by app rabbit
2020-09-03 02:50:37.759 [info] <0.269.0> Running boot step rabbit_vhost_limit defined by app rabbit
2020-09-03 02:50:37.759 [info] <0.269.0> Running boot step recovery defined by app rabbit
2020-09-03 02:50:37.761 [info] <0.269.0> Running boot step empty_db_check defined by app rabbit
2020-09-03 02:50:37.761 [info] <0.269.0> Will seed default virtual host and user...
2020-09-03 02:50:37.761 [info] <0.269.0> Adding vhost '/' (description: 'Default virtual host')
2020-09-03 02:50:37.774 [info] <0.625.0> Making sure data directory '/var/lib/rabbitmq/mnesia/rabbit@8ae319d26a5c/msg_stores/vhosts/628WB79CIFDYO9LJI6DKMI09L' for vhost '/' exists
2020-09-03 02:50:37.780 [info] <0.625.0> Starting message stores for vhost '/'
2020-09-03 02:50:37.781 [info] <0.629.0> Message store "628WB79CIFDYO9LJI6DKMI09L/msg_store_transient": using rabbit_msg_store_ets_index to provide index
2020-09-03 02:50:37.784 [info] <0.625.0> Started message store of type transient for vhost '/'
2020-09-03 02:50:37.785 [info] <0.633.0> Message store "628WB79CIFDYO9LJI6DKMI09L/msg_store_persistent": using rabbit_msg_store_ets_index to provide index
2020-09-03 02:50:37.787 [warning] <0.633.0> Message store "628WB79CIFDYO9LJI6DKMI09L/msg_store_persistent": rebuilding indices from scratch
2020-09-03 02:50:37.789 [info] <0.625.0> Started message store of type persistent for vhost '/'
2020-09-03 02:50:37.794 [info] <0.269.0> Created user 'guest'
2020-09-03 02:50:37.797 [info] <0.269.0> Successfully set user tags for user 'guest' to [administrator]
2020-09-03 02:50:37.799 [info] <0.269.0> Successfully set permissions for 'guest' in virtual host '/' to '.*', '.*', '.*'
2020-09-03 02:50:37.799 [info] <0.269.0> Running boot step rabbit_looking_glass defined by app rabbit
2020-09-03 02:50:37.799 [info] <0.269.0> Running boot step rabbit_core_metrics_gc defined by app rabbit
2020-09-03 02:50:37.799 [info] <0.269.0> Running boot step background_gc defined by app rabbit
2020-09-03 02:50:37.800 [info] <0.269.0> Running boot step connection_tracking defined by app rabbit
2020-09-03 02:50:37.807 [info] <0.269.0> Setting up a table for connection tracking on this node: tracked_connection_on_node_rabbit@8ae319d26a5c
2020-09-03 02:50:37.811 [info] <0.269.0> Setting up a table for per-vhost connection counting on this node: tracked_connection_per_vhost_on_node_rabbit@8ae319d26a5c
2020-09-03 02:50:37.812 [info] <0.269.0> Running boot step routing_ready defined by app rabbit
2020-09-03 02:50:37.812 [info] <0.269.0> Running boot step pre_flight defined by app rabbit
2020-09-03 02:50:37.812 [info] <0.269.0> Running boot step notify_cluster defined by app rabbit
2020-09-03 02:50:37.812 [info] <0.269.0> Running boot step networking defined by app rabbit
2020-09-03 02:50:37.814 [info] <0.269.0> Running boot step definition_import_worker_pool defined by app rabbit
2020-09-03 02:50:37.816 [info] <0.345.0> Starting worker pool 'definition_import_pool' with 1 processes in it
2020-09-03 02:50:37.818 [info] <0.269.0> Running boot step cluster_name defined by app rabbit
2020-09-03 02:50:37.818 [info] <0.269.0> Initialising internal cluster ID to 'rabbitmq-cluster-id-PyAald6jet-hlmjAIs4Nrw'
2020-09-03 02:50:37.820 [info] <0.269.0> Running boot step direct_client defined by app rabbit
2020-09-03 02:50:37.821 [info] <0.44.0> Application rabbit started on node rabbit@8ae319d26a5c
2020-09-03 02:50:38.572 [info] <0.671.0> Feature flags: list of feature flags found:
2020-09-03 02:50:38.572 [info] <0.671.0> Feature flags:   [ ] drop_unroutable_metric
2020-09-03 02:50:38.573 [info] <0.671.0> Feature flags:   [ ] empty_basic_get_metric
2020-09-03 02:50:38.573 [info] <0.671.0> Feature flags:   [x] implicit_default_bindings
2020-09-03 02:50:38.573 [info] <0.671.0> Feature flags:   [x] quorum_queue
2020-09-03 02:50:38.573 [info] <0.671.0> Feature flags:   [x] virtual_host_metadata
2020-09-03 02:50:38.574 [info] <0.671.0> Feature flags: feature flag states written to disk: yes
2020-09-03 02:50:38.835 [info] <0.44.0> Application cowlib started on node rabbit@8ae319d26a5c
2020-09-03 02:50:38.843 [info] <0.44.0> Application cowboy started on node rabbit@8ae319d26a5c
2020-09-03 02:50:38.851 [info] <0.671.0> Running boot step rabbit_mgmt_db_handler defined by app rabbitmq_management_agent
2020-09-03 02:50:38.851 [info] <0.671.0> Management plugin: using rates mode 'basic'
2020-09-03 02:50:38.856 [info] <0.44.0> Application rabbitmq_management_agent started on node rabbit@8ae319d26a5c
2020-09-03 02:50:38.882 [info] <0.44.0> Application prometheus started on node rabbit@8ae319d26a5c
2020-09-03 02:50:38.896 [info] <0.44.0> Application rabbitmq_web_dispatch started on node rabbit@8ae319d26a5c
2020-09-03 02:50:38.924 [info] <0.703.0> Prometheus metrics: HTTP (non-TLS) listener started on port 15692
2020-09-03 02:50:38.925 [info] <0.671.0> Ready to start client connection listeners
2020-09-03 02:50:38.925 [info] <0.44.0> Application rabbitmq_prometheus started on node rabbit@8ae319d26a5c
2020-09-03 02:50:38.929 [info] <0.822.0> started TCP listener on [::]:5672
2020-09-03 02:50:39.775 [info] <0.671.0> Server startup complete; 3 plugins started.
 * rabbitmq_prometheus
 * rabbitmq_web_dispatch
 * rabbitmq_management_agent
 completed with 3 plugins.
2020-09-03 05:07:54.009 [info] <0.60.0> SIGTERM received - shutting down
2020-09-03 05:07:54.013 [warning] <0.699.0> HTTP listener registry could not find context rabbitmq_prometheus_tls
2020-09-03 05:07:54.024 [info] <0.269.0> Peer discovery backend rabbit_peer_discovery_classic_config does not support registration, skipping unregistration.
2020-09-03 05:07:54.025 [info] <0.822.0> stopped TCP listener on [::]:5672
2020-09-03 05:07:54.026 [info] <0.609.0> Closing all connections in vhost '/' on node 'rabbit@8ae319d26a5c' because the vhost is stopping
2020-09-03 05:07:54.026 [info] <0.633.0> Stopping message store for directory '/var/lib/rabbitmq/mnesia/rabbit@8ae319d26a5c/msg_stores/vhosts/628WB79CIFDYO9LJI6DKMI09L/msg_store_persistent'
2020-09-03 05:07:54.038 [info] <0.633.0> Message store for directory '/var/lib/rabbitmq/mnesia/rabbit@8ae319d26a5c/msg_stores/vhosts/628WB79CIFDYO9LJI6DKMI09L/msg_store_persistent' is stopped
2020-09-03 05:07:54.040 [info] <0.629.0> Stopping message store for directory '/var/lib/rabbitmq/mnesia/rabbit@8ae319d26a5c/msg_stores/vhosts/628WB79CIFDYO9LJI6DKMI09L/msg_store_transient'
2020-09-03 05:07:54.047 [info] <0.629.0> Message store for directory '/var/lib/rabbitmq/mnesia/rabbit@8ae319d26a5c/msg_stores/vhosts/628WB79CIFDYO9LJI6DKMI09L/msg_store_transient' is stopped
Configuring logger redirection
2020-09-03 05:08:05.755 [debug] <0.286.0> Lager installed handler error_logger_lager_h into error_logger
2020-09-03 05:08:05.792 [debug] <0.289.0> Lager installed handler lager_forwarder_backend into error_logger_lager_event
2020-09-03 05:08:05.792 [debug] <0.292.0> Lager installed handler lager_forwarder_backend into rabbit_log_lager_event
2020-09-03 05:08:05.792 [debug] <0.295.0> Lager installed handler lager_forwarder_backend into rabbit_log_channel_lager_event
2020-09-03 05:08:05.793 [debug] <0.298.0> Lager installed handler lager_forwarder_backend into rabbit_log_connection_lager_event
2020-09-03 05:08:05.793 [debug] <0.301.0> Lager installed handler lager_forwarder_backend into rabbit_log_feature_flags_lager_event
2020-09-03 05:08:05.793 [debug] <0.304.0> Lager installed handler lager_forwarder_backend into rabbit_log_federation_lager_event
2020-09-03 05:08:05.793 [debug] <0.307.0> Lager installed handler lager_forwarder_backend into rabbit_log_ldap_lager_event
2020-09-03 05:08:05.793 [debug] <0.310.0> Lager installed handler lager_forwarder_backend into rabbit_log_mirroring_lager_event
2020-09-03 05:08:05.793 [debug] <0.313.0> Lager installed handler lager_forwarder_backend into rabbit_log_prelaunch_lager_event
2020-09-03 05:08:05.793 [debug] <0.316.0> Lager installed handler lager_forwarder_backend into rabbit_log_queue_lager_event
2020-09-03 05:08:05.793 [debug] <0.319.0> Lager installed handler lager_forwarder_backend into rabbit_log_ra_lager_event
2020-09-03 05:08:05.793 [debug] <0.322.0> Lager installed handler lager_forwarder_backend into rabbit_log_shovel_lager_event
2020-09-03 05:08:05.793 [debug] <0.325.0> Lager installed handler lager_forwarder_backend into rabbit_log_upgrade_lager_event
2020-09-03 05:08:05.817 [info] <0.44.0> Application lager started on node rabbit@8ae319d26a5c
2020-09-03 05:08:06.255 [debug] <0.282.0> Lager installed handler lager_backend_throttle into lager_event
2020-09-03 05:08:10.747 [info] <0.44.0> Application mnesia started on node rabbit@8ae319d26a5c
2020-09-03 05:08:10.749 [info] <0.269.0> 
 Starting RabbitMQ 3.8.7 on Erlang 23.0.3
 Copyright (c) 2007-2020 VMware, Inc. or its affiliates.
 Licensed under the MPL 2.0. Website: https://rabbitmq.com
  ##  ##      RabbitMQ 3.8.7
  ##  ##
  ##########  Copyright (c) 2007-2020 VMware, Inc. or its affiliates.
  ######  ##
  ##########  Licensed under the MPL 2.0. Website: https://rabbitmq.com
  Doc guides: https://rabbitmq.com/documentation.html
  Support:    https://rabbitmq.com/contact.html
  Tutorials:  https://rabbitmq.com/getstarted.html
  Monitoring: https://rabbitmq.com/monitoring.html
  Logs: <stdout>
  Config file(s): /etc/rabbitmq/rabbitmq.conf
                  /etc/rabbitmq/conf.d/management_agent.disable_metrics_collector.conf
  Starting broker...2020-09-03 05:08:10.761 [info] <0.269.0> 
 node           : rabbit@8ae319d26a5c
 home dir       : /var/lib/rabbitmq
 config file(s) : /etc/rabbitmq/rabbitmq.conf
                : /etc/rabbitmq/conf.d/management_agent.disable_metrics_collector.conf
 cookie hash    : UdJvdBP/qV2ngs8HAy442g==
 log(s)         : <stdout>
 database dir   : /var/lib/rabbitmq/mnesia/rabbit@8ae319d26a5c
2020-09-03 05:08:10.773 [info] <0.269.0> Running boot step pre_boot defined by app rabbit
2020-09-03 05:08:10.773 [info] <0.269.0> Running boot step rabbit_core_metrics defined by app rabbit
2020-09-03 05:08:10.775 [info] <0.269.0> Running boot step rabbit_alarm defined by app rabbit
2020-09-03 05:08:10.806 [info] <0.389.0> Memory high watermark set to 797 MiB (836086988 bytes) of 1993 MiB (2090217472 bytes) total
2020-09-03 05:08:10.839 [info] <0.405.0> Enabling free disk space monitoring
2020-09-03 05:08:10.840 [info] <0.405.0> Disk free limit set to 50MB
2020-09-03 05:08:10.855 [info] <0.269.0> Running boot step code_server_cache defined by app rabbit
2020-09-03 05:08:10.856 [info] <0.269.0> Running boot step file_handle_cache defined by app rabbit
2020-09-03 05:08:10.856 [info] <0.437.0> Limiting to approx 1048479 file handles (943629 sockets)
2020-09-03 05:08:10.857 [info] <0.438.0> FHC read buffering:  OFF
2020-09-03 05:08:10.858 [info] <0.438.0> FHC write buffering: ON
2020-09-03 05:08:10.860 [info] <0.269.0> Running boot step worker_pool defined by app rabbit
2020-09-03 05:08:10.860 [info] <0.374.0> Will use 1 processes for default worker pool
2020-09-03 05:08:10.860 [info] <0.374.0> Starting worker pool 'worker_pool' with 1 processes in it
2020-09-03 05:08:10.861 [info] <0.269.0> Running boot step database defined by app rabbit
2020-09-03 05:08:10.869 [info] <0.269.0> Waiting for Mnesia tables for 30000 ms, 9 retries left
2020-09-03 05:08:10.871 [info] <0.269.0> Successfully synced tables from a peer
2020-09-03 05:08:10.871 [info] <0.269.0> Waiting for Mnesia tables for 30000 ms, 9 retries left
2020-09-03 05:08:10.872 [info] <0.269.0> Successfully synced tables from a peer
2020-09-03 05:08:10.890 [info] <0.269.0> Waiting for Mnesia tables for 30000 ms, 9 retries left
2020-09-03 05:08:10.891 [info] <0.269.0> Successfully synced tables from a peer
2020-09-03 05:08:10.891 [info] <0.269.0> Peer discovery backend rabbit_peer_discovery_classic_config does not support registration, skipping registration.
2020-09-03 05:08:10.891 [info] <0.269.0> Running boot step database_sync defined by app rabbit
2020-09-03 05:08:10.891 [info] <0.269.0> Running boot step feature_flags defined by app rabbit
2020-09-03 05:08:10.893 [info] <0.269.0> Running boot step codec_correctness_check defined by app rabbit
2020-09-03 05:08:10.893 [info] <0.269.0> Running boot step external_infrastructure defined by app rabbit
2020-09-03 05:08:10.893 [info] <0.269.0> Running boot step rabbit_registry defined by app rabbit
2020-09-03 05:08:10.893 [info] <0.269.0> Running boot step rabbit_auth_mechanism_cr_demo defined by app rabbit
2020-09-03 05:08:10.895 [info] <0.269.0> Running boot step rabbit_queue_location_random defined by app rabbit
2020-09-03 05:08:10.895 [info] <0.269.0> Running boot step rabbit_event defined by app rabbit
2020-09-03 05:08:10.895 [info] <0.269.0> Running boot step rabbit_auth_mechanism_amqplain defined by app rabbit
2020-09-03 05:08:10.896 [info] <0.269.0> Running boot step rabbit_auth_mechanism_plain defined by app rabbit
2020-09-03 05:08:10.896 [info] <0.269.0> Running boot step rabbit_exchange_type_direct defined by app rabbit
2020-09-03 05:08:10.897 [info] <0.269.0> Running boot step rabbit_exchange_type_fanout defined by app rabbit
2020-09-03 05:08:10.897 [info] <0.269.0> Running boot step rabbit_exchange_type_headers defined by app rabbit
2020-09-03 05:08:10.897 [info] <0.269.0> Running boot step rabbit_exchange_type_topic defined by app rabbit
2020-09-03 05:08:10.898 [info] <0.269.0> Running boot step rabbit_mirror_queue_mode_all defined by app rabbit
2020-09-03 05:08:10.899 [info] <0.269.0> Running boot step rabbit_mirror_queue_mode_exactly defined by app rabbit
2020-09-03 05:08:10.899 [info] <0.269.0> Running boot step rabbit_mirror_queue_mode_nodes defined by app rabbit
2020-09-03 05:08:10.900 [info] <0.269.0> Running boot step rabbit_priority_queue defined by app rabbit
2020-09-03 05:08:10.900 [info] <0.269.0> Priority queues enabled, real BQ is rabbit_variable_queue
2020-09-03 05:08:10.900 [info] <0.269.0> Running boot step rabbit_queue_location_client_local defined by app rabbit
2020-09-03 05:08:10.901 [info] <0.269.0> Running boot step rabbit_queue_location_min_masters defined by app rabbit
2020-09-03 05:08:10.902 [info] <0.269.0> Running boot step kernel_ready defined by app rabbit
2020-09-03 05:08:10.902 [info] <0.269.0> Running boot step rabbit_sysmon_minder defined by app rabbit
2020-09-03 05:08:10.902 [info] <0.269.0> Running boot step rabbit_epmd_monitor defined by app rabbit
2020-09-03 05:08:10.904 [info] <0.457.0> epmd monitor knows us, inter-node communication (distribution) port: 25672
2020-09-03 05:08:10.904 [info] <0.269.0> Running boot step guid_generator defined by app rabbit
2020-09-03 05:08:10.909 [info] <0.269.0> Running boot step rabbit_node_monitor defined by app rabbit
2020-09-03 05:08:10.910 [info] <0.461.0> Starting rabbit_node_monitor
2020-09-03 05:08:10.912 [info] <0.269.0> Running boot step delegate_sup defined by app rabbit
2020-09-03 05:08:10.914 [info] <0.269.0> Running boot step rabbit_memory_monitor defined by app rabbit
2020-09-03 05:08:10.915 [info] <0.269.0> Running boot step core_initialized defined by app rabbit
2020-09-03 05:08:10.915 [info] <0.269.0> Running boot step upgrade_queues defined by app rabbit
2020-09-03 05:08:10.929 [info] <0.269.0> Running boot step rabbit_connection_tracking defined by app rabbit
2020-09-03 05:08:10.930 [info] <0.269.0> Running boot step rabbit_connection_tracking_handler defined by app rabbit
2020-09-03 05:08:10.930 [info] <0.269.0> Running boot step rabbit_exchange_parameters defined by app rabbit
2020-09-03 05:08:10.930 [info] <0.269.0> Running boot step rabbit_mirror_queue_misc defined by app rabbit
2020-09-03 05:08:10.931 [info] <0.269.0> Running boot step rabbit_policies defined by app rabbit
2020-09-03 05:08:10.933 [info] <0.269.0> Running boot step rabbit_policy defined by app rabbit
2020-09-03 05:08:10.933 [info] <0.269.0> Running boot step rabbit_queue_location_validator defined by app rabbit
2020-09-03 05:08:10.933 [info] <0.269.0> Running boot step rabbit_quorum_memory_manager defined by app rabbit
2020-09-03 05:08:10.933 [info] <0.269.0> Running boot step rabbit_vhost_limit defined by app rabbit
2020-09-03 05:08:10.933 [info] <0.269.0> Running boot step recovery defined by app rabbit
2020-09-03 05:08:10.936 [info] <0.490.0> Making sure data directory '/var/lib/rabbitmq/mnesia/rabbit@8ae319d26a5c/msg_stores/vhosts/628WB79CIFDYO9LJI6DKMI09L' for vhost '/' exists
2020-09-03 05:08:10.944 [info] <0.490.0> Starting message stores for vhost '/'
2020-09-03 05:08:10.945 [info] <0.494.0> Message store "628WB79CIFDYO9LJI6DKMI09L/msg_store_transient": using rabbit_msg_store_ets_index to provide index
2020-09-03 05:08:10.949 [info] <0.490.0> Started message store of type transient for vhost '/'
2020-09-03 05:08:10.949 [info] <0.498.0> Message store "628WB79CIFDYO9LJI6DKMI09L/msg_store_persistent": using rabbit_msg_store_ets_index to provide index
2020-09-03 05:08:10.956 [info] <0.490.0> Started message store of type persistent for vhost '/'
2020-09-03 05:08:10.959 [info] <0.269.0> Running boot step empty_db_check defined by app rabbit
2020-09-03 05:08:10.959 [info] <0.269.0> Will not seed default virtual host and user: have definitions to load...
2020-09-03 05:08:10.960 [info] <0.269.0> Running boot step rabbit_looking_glass defined by app rabbit
2020-09-03 05:08:10.960 [info] <0.269.0> Running boot step rabbit_core_metrics_gc defined by app rabbit
2020-09-03 05:08:10.961 [info] <0.269.0> Running boot step background_gc defined by app rabbit
2020-09-03 05:08:10.962 [info] <0.269.0> Running boot step connection_tracking defined by app rabbit
2020-09-03 05:08:10.962 [info] <0.269.0> Setting up a table for connection tracking on this node: tracked_connection_on_node_rabbit@8ae319d26a5c
2020-09-03 05:08:10.963 [info] <0.269.0> Setting up a table for per-vhost connection counting on this node: tracked_connection_per_vhost_on_node_rabbit@8ae319d26a5c
2020-09-03 05:08:10.964 [info] <0.269.0> Running boot step routing_ready defined by app rabbit
2020-09-03 05:08:10.964 [info] <0.269.0> Running boot step pre_flight defined by app rabbit
2020-09-03 05:08:10.964 [info] <0.269.0> Running boot step notify_cluster defined by app rabbit
2020-09-03 05:08:10.964 [info] <0.269.0> Running boot step networking defined by app rabbit
2020-09-03 05:08:10.964 [info] <0.269.0> Running boot step definition_import_worker_pool defined by app rabbit
2020-09-03 05:08:10.966 [info] <0.374.0> Starting worker pool 'definition_import_pool' with 1 processes in it
2020-09-03 05:08:10.968 [info] <0.269.0> Running boot step cluster_name defined by app rabbit
2020-09-03 05:08:10.968 [info] <0.269.0> Running boot step direct_client defined by app rabbit
2020-09-03 05:08:10.972 [info] <0.44.0> Application rabbit started on node rabbit@8ae319d26a5c
2020-09-03 05:08:11.717 [info] <0.525.0> Feature flags: list of feature flags found:
2020-09-03 05:08:11.717 [info] <0.525.0> Feature flags:   [ ] drop_unroutable_metric
2020-09-03 05:08:11.717 [info] <0.525.0> Feature flags:   [ ] empty_basic_get_metric
2020-09-03 05:08:11.717 [info] <0.525.0> Feature flags:   [x] implicit_default_bindings
2020-09-03 05:08:11.718 [info] <0.525.0> Feature flags:   [x] quorum_queue
2020-09-03 05:08:11.718 [info] <0.525.0> Feature flags:   [x] virtual_host_metadata
2020-09-03 05:08:11.719 [info] <0.525.0> Feature flags: feature flag states written to disk: yes
2020-09-03 05:08:11.994 [info] <0.44.0> Application cowlib started on node rabbit@8ae319d26a5c
2020-09-03 05:08:12.003 [info] <0.44.0> Application cowboy started on node rabbit@8ae319d26a5c
2020-09-03 05:08:12.012 [info] <0.525.0> Running boot step rabbit_mgmt_db_handler defined by app rabbitmq_management_agent
2020-09-03 05:08:12.012 [info] <0.525.0> Management plugin: using rates mode 'basic'
2020-09-03 05:08:12.017 [info] <0.44.0> Application rabbitmq_management_agent started on node rabbit@8ae319d26a5c
2020-09-03 05:08:12.044 [info] <0.44.0> Application prometheus started on node rabbit@8ae319d26a5c
2020-09-03 05:08:12.054 [info] <0.44.0> Application rabbitmq_web_dispatch started on node rabbit@8ae319d26a5c
2020-09-03 05:08:12.068 [info] <0.557.0> Prometheus metrics: HTTP (non-TLS) listener started on port 15692
2020-09-03 05:08:12.070 [info] <0.525.0> Ready to start client connection listeners
2020-09-03 05:08:12.070 [info] <0.44.0> Application rabbitmq_prometheus started on node rabbit@8ae319d26a5c
2020-09-03 05:08:12.073 [info] <0.676.0> started TCP listener on [::]:5672
2020-09-03 05:08:12.958 [info] <0.525.0> Server startup complete; 3 plugins started.
 * rabbitmq_prometheus
 * rabbitmq_web_dispatch
 * rabbitmq_management_agent
 completed with 3 plugins.
IP & PORTS
You can access this container using the following IP address and port:

DOCKER PORT	ACCESS URL
4369/tcp	192.168.99.100:32922
5671/tcp	192.168.99.100:32921
5672/tcp	192.168.99.100:32920
15691/tcp	192.168.99.100:32919
15692/tcp	192.168.99.100:32918
25672/tcp	192.168.99.100:32917

 Error on AMQP connection <0.1373.0> (192.168.99.1:62284 -> 172.17.0.5:5672, state: starting):
PLAIN login refused: user 'guest' attempted to log in with a blank password, which is prohibited by the internal authN backend. To use TLS/x509 certificate-based authentication, see the rabbitmq_auth_mechanism_ssl plugin and configure the client to use the EXTERNAL authentication mechanism. Alternatively change the password for the user to be non-blank.
2020-09-03 05:19:39.496 [info] <0.1373.0> closing AMQP connection <0.1373.0> (192.168.99.1:62284 -> 172.17.0.5:5672 - rabbitConnectionFactory#6bf570c:0)





"C:\Program Files\Java\jdk1.8.0_212\bin\java.exe" -XX:TieredStopAtLevel=1 -noverify -Dspring.output.ansi.enabled=always -Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true -javaagent:C:\Users\Administrator\AppData\Local\JetBrains\Toolbox\apps\IDEA-U\ch-0\192.7142.36\lib\idea_rt.jar=62491:C:\Users\Administrator\AppData\Local\JetBrains\Toolbox\apps\IDEA-U\ch-0\192.7142.36\bin -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_212\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_212\jre\lib\rt.jar;E:\dbblog-master\dbblog-backend\dbblog-search\target\classes;E:\dbblog-master\dbblog-backend\dbblog-portal\target\classes;E:\dbblog-master\dbblog-backend\dbblog-manage\target\classes;E:\dbblog-master\dbblog-backend\dbblog-auth\target\classes;E:\dbblog-master\dbblog-backend\dbblog-core\target\classes;C:\Users\Administrator\.m2\repository\org\projectlombok\lombok\1.18.4\lombok-1.18.4.jar;C:\Users\Administrator\.m2\repository\io\springfox\springfox-swagger2\2.4.0\springfox-swagger2-2.4.0.jar;C:\Users\Administrator\.m2\repository\io\swagger\swagger-annotations\1.5.6\swagger-annotations-1.5.6.jar;C:\Users\Administrator\.m2\repository\io\swagger\swagger-models\1.5.6\swagger-models-1.5.6.jar;C:\Users\Administrator\.m2\repository\com\fasterxml\jackson\core\jackson-annotations\2.6.3\jackson-annotations-2.6.3.jar;C:\Users\Administrator\.m2\repository\io\springfox\springfox-spi\2.4.0\springfox-spi-2.4.0.jar;C:\Users\Administrator\.m2\repository\io\springfox\springfox-core\2.4.0\springfox-core-2.4.0.jar;C:\Users\Administrator\.m2\repository\io\springfox\springfox-schema\2.4.0\springfox-schema-2.4.0.jar;C:\Users\Administrator\.m2\repository\io\springfox\springfox-swagger-common\2.4.0\springfox-swagger-common-2.4.0.jar;C:\Users\Administrator\.m2\repository\io\springfox\springfox-spring-web\2.4.0\springfox-spring-web-2.4.0.jar;C:\Users\Administrator\.m2\repository\com\google\guava\guava\18.0\guava-18.0.jar;C:\Users\Administrator\.m2\repository\com\fasterxml\classmate\1.4.0\classmate-1.4.0.jar;C:\Users\Administrator\.m2\repository\org\slf4j\slf4j-api\1.7.28\slf4j-api-1.7.28.jar;C:\Users\Administrator\.m2\repository\org\springframework\plugin\spring-plugin-core\1.2.0.RELEASE\spring-plugin-core-1.2.0.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\spring-beans\5.1.8.RELEASE\spring-beans-5.1.8.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\spring-context\5.1.8.RELEASE\spring-context-5.1.8.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\plugin\spring-plugin-metadata\1.2.0.RELEASE\spring-plugin-metadata-1.2.0.RELEASE.jar;C:\Users\Administrator\.m2\repository\io\springfox\springfox-swagger-ui\2.9.2\springfox-swagger-ui-2.9.2.jar;C:\Users\Administrator\.m2\repository\commons-lang\commons-lang\2.6\commons-lang-2.6.jar;C:\Users\Administrator\.m2\repository\commons-fileupload\commons-fileupload\1.4\commons-fileupload-1.4.jar;C:\Users\Administrator\.m2\repository\commons-io\commons-io\2.5\commons-io-2.5.jar;C:\Users\Administrator\.m2\repository\com\github\ulisesbocchio\jasypt-spring-boot-starter\2.1.0\jasypt-spring-boot-starter-2.1.0.jar;C:\Users\Administrator\.m2\repository\com\github\ulisesbocchio\jasypt-spring-boot\2.1.0\jasypt-spring-boot-2.1.0.jar;C:\Users\Administrator\.m2\repository\org\jasypt\jasypt\1.9.2\jasypt-1.9.2.jar;C:\Users\Administrator\.m2\repository\org\springframework\boot\spring-boot-starter-web\2.1.2.RELEASE\spring-boot-starter-web-2.1.2.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\boot\spring-boot-starter\2.1.6.RELEASE\spring-boot-starter-2.1.6.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\boot\spring-boot\2.1.6.RELEASE\spring-boot-2.1.6.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\boot\spring-boot-starter-logging\2.1.6.RELEASE\spring-boot-starter-logging-2.1.6.RELEASE.jar;C:\Users\Administrator\.m2\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;C:\Users\Administrator\.m2\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;C:\Users\Administrator\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.11.2\log4j-to-slf4j-2.11.2.jar;C:\Users\Administrator\.m2\repository\org\apache\logging\log4j\log4j-api\2.11.2\log4j-api-2.11.2.jar;C:\Users\Administrator\.m2\repository\org\slf4j\jul-to-slf4j\1.7.26\jul-to-slf4j-1.7.26.jar;C:\Users\Administrator\.m2\repository\javax\annotation\javax.annotation-api\1.3.2\javax.annotation-api-1.3.2.jar;C:\Users\Administrator\.m2\repository\org\yaml\snakeyaml\1.23\snakeyaml-1.23.jar;C:\Users\Administrator\.m2\repository\org\springframework\boot\spring-boot-starter-json\2.1.6.RELEASE\spring-boot-starter-json-2.1.6.RELEASE.jar;C:\Users\Administrator\.m2\repository\com\fasterxml\jackson\core\jackson-databind\2.6.3\jackson-databind-2.6.3.jar;C:\Users\Administrator\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jdk8\2.9.9\jackson-datatype-jdk8-2.9.9.jar;C:\Users\Administrator\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.9.9\jackson-datatype-jsr310-2.9.9.jar;C:\Users\Administrator\.m2\repository\com\fasterxml\jackson\module\jackson-module-parameter-names\2.9.9\jackson-module-parameter-names-2.9.9.jar;C:\Users\Administrator\.m2\repository\org\springframework\boot\spring-boot-starter-tomcat\2.1.6.RELEASE\spring-boot-starter-tomcat-2.1.6.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\apache\tomcat\embed\tomcat-embed-core\9.0.21\tomcat-embed-core-9.0.21.jar;C:\Users\Administrator\.m2\repository\org\apache\tomcat\embed\tomcat-embed-el\9.0.21\tomcat-embed-el-9.0.21.jar;C:\Users\Administrator\.m2\repository\org\apache\tomcat\embed\tomcat-embed-websocket\9.0.21\tomcat-embed-websocket-9.0.21.jar;C:\Users\Administrator\.m2\repository\org\hibernate\validator\hibernate-validator\6.0.17.Final\hibernate-validator-6.0.17.Final.jar;C:\Users\Administrator\.m2\repository\javax\validation\validation-api\2.0.1.Final\validation-api-2.0.1.Final.jar;C:\Users\Administrator\.m2\repository\org\jboss\logging\jboss-logging\3.3.2.Final\jboss-logging-3.3.2.Final.jar;C:\Users\Administrator\.m2\repository\org\springframework\spring-web\5.1.8.RELEASE\spring-web-5.1.8.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\spring-webmvc\5.1.8.RELEASE\spring-webmvc-5.1.8.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\spring-expression\5.1.8.RELEASE\spring-expression-5.1.8.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\boot\spring-boot-starter-aop\2.1.2.RELEASE\spring-boot-starter-aop-2.1.2.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\spring-aop\5.1.8.RELEASE\spring-aop-5.1.8.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\aspectj\aspectjweaver\1.9.4\aspectjweaver-1.9.4.jar;C:\Users\Administrator\.m2\repository\org\apache\shiro\shiro-spring\1.4.0\shiro-spring-1.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\shiro\shiro-core\1.4.0\shiro-core-1.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\shiro\shiro-lang\1.4.0\shiro-lang-1.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\shiro\shiro-cache\1.4.0\shiro-cache-1.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\shiro\shiro-crypto-hash\1.4.0\shiro-crypto-hash-1.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\shiro\shiro-crypto-core\1.4.0\shiro-crypto-core-1.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\shiro\shiro-crypto-cipher\1.4.0\shiro-crypto-cipher-1.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\shiro\shiro-config-core\1.4.0\shiro-config-core-1.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\shiro\shiro-config-ogdl\1.4.0\shiro-config-ogdl-1.4.0.jar;C:\Users\Administrator\.m2\repository\commons-beanutils\commons-beanutils\1.9.3\commons-beanutils-1.9.3.jar;C:\Users\Administrator\.m2\repository\commons-collections\commons-collections\3.2.2\commons-collections-3.2.2.jar;C:\Users\Administrator\.m2\repository\org\apache\shiro\shiro-event\1.4.0\shiro-event-1.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\shiro\shiro-web\1.4.0\shiro-web-1.4.0.jar;C:\Users\Administrator\.m2\repository\com\github\axet\kaptcha\0.0.9\kaptcha-0.0.9.jar;C:\Users\Administrator\.m2\repository\com\jhlabs\filters\2.0.235\filters-2.0.235.jar;C:\Users\Administrator\.m2\repository\com\qiniu\qiniu-java-sdk\7.2.29\qiniu-java-sdk-7.2.29.jar;C:\Users\Administrator\.m2\repository\com\squareup\okhttp3\okhttp\3.14.4\okhttp-3.14.4.jar;C:\Users\Administrator\.m2\repository\com\squareup\okio\okio\1.17.2\okio-1.17.2.jar;C:\Users\Administrator\.m2\repository\com\google\code\gson\gson\2.8.5\gson-2.8.5.jar;C:\Users\Administrator\.m2\repository\org\springframework\boot\spring-boot-starter-test\2.1.2.RELEASE\spring-boot-starter-test-2.1.2.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\boot\spring-boot-test\2.1.6.RELEASE\spring-boot-test-2.1.6.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\boot\spring-boot-test-autoconfigure\2.1.6.RELEASE\spring-boot-test-autoconfigure-2.1.6.RELEASE.jar;C:\Users\Administrator\.m2\repository\com\jayway\jsonpath\json-path\2.4.0\json-path-2.4.0.jar;C:\Users\Administrator\.m2\repository\net\minidev\json-smart\2.3\json-smart-2.3.jar;C:\Users\Administrator\.m2\repository\net\minidev\accessors-smart\1.2\accessors-smart-1.2.jar;C:\Users\Administrator\.m2\repository\org\ow2\asm\asm\5.0.4\asm-5.0.4.jar;C:\Users\Administrator\.m2\repository\junit\junit\4.12\junit-4.12.jar;C:\Users\Administrator\.m2\repository\org\assertj\assertj-core\3.11.1\assertj-core-3.11.1.jar;C:\Users\Administrator\.m2\repository\org\mockito\mockito-core\2.23.4\mockito-core-2.23.4.jar;C:\Users\Administrator\.m2\repository\net\bytebuddy\byte-buddy\1.9.13\byte-buddy-1.9.13.jar;C:\Users\Administrator\.m2\repository\net\bytebuddy\byte-buddy-agent\1.9.13\byte-buddy-agent-1.9.13.jar;C:\Users\Administrator\.m2\repository\org\objenesis\objenesis\2.6\objenesis-2.6.jar;C:\Users\Administrator\.m2\repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;C:\Users\Administrator\.m2\repository\org\hamcrest\hamcrest-library\1.3\hamcrest-library-1.3.jar;C:\Users\Administrator\.m2\repository\org\skyscreamer\jsonassert\1.5.0\jsonassert-1.5.0.jar;C:\Users\Administrator\.m2\repository\com\vaadin\external\google\android-json\0.0.20131108.vaadin1\android-json-0.0.20131108.vaadin1.jar;C:\Users\Administrator\.m2\repository\org\springframework\spring-core\5.1.8.RELEASE\spring-core-5.1.8.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\spring-jcl\5.1.8.RELEASE\spring-jcl-5.1.8.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\spring-test\5.1.8.RELEASE\spring-test-5.1.8.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\xmlunit\xmlunit-core\2.6.2\xmlunit-core-2.6.2.jar;C:\Users\Administrator\.m2\repository\javax\xml\bind\jaxb-api\2.3.1\jaxb-api-2.3.1.jar;C:\Users\Administrator\.m2\repository\javax\activation\javax.activation-api\1.2.0\javax.activation-api-1.2.0.jar;C:\Users\Administrator\.m2\repository\org\mybatis\spring\boot\mybatis-spring-boot-starter\1.3.2\mybatis-spring-boot-starter-1.3.2.jar;C:\Users\Administrator\.m2\repository\org\springframework\boot\spring-boot-starter-jdbc\2.1.6.RELEASE\spring-boot-starter-jdbc-2.1.6.RELEASE.jar;C:\Users\Administrator\.m2\repository\com\zaxxer\HikariCP\3.2.0\HikariCP-3.2.0.jar;C:\Users\Administrator\.m2\repository\org\springframework\spring-jdbc\5.1.8.RELEASE\spring-jdbc-5.1.8.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\mybatis\spring\boot\mybatis-spring-boot-autoconfigure\1.3.2\mybatis-spring-boot-autoconfigure-1.3.2.jar;C:\Users\Administrator\.m2\repository\org\mybatis\mybatis\3.4.5\mybatis-3.4.5.jar;C:\Users\Administrator\.m2\repository\org\mybatis\mybatis-spring\1.3.2\mybatis-spring-1.3.2.jar;C:\Users\Administrator\.m2\repository\mysql\mysql-connector-java\8.0.11\mysql-connector-java-8.0.11.jar;C:\Users\Administrator\.m2\repository\com\google\protobuf\protobuf-java\2.6.0\protobuf-java-2.6.0.jar;C:\Users\Administrator\.m2\repository\com\baomidou\mybatis-plus-boot-starter\3.0.1\mybatis-plus-boot-starter-3.0.1.jar;C:\Users\Administrator\.m2\repository\com\baomidou\mybatis-plus\3.0.1\mybatis-plus-3.0.1.jar;C:\Users\Administrator\.m2\repository\com\baomidou\mybatis-plus-extension\3.0.1\mybatis-plus-extension-3.0.1.jar;C:\Users\Administrator\.m2\repository\com\baomidou\mybatis-plus-core\3.0.1\mybatis-plus-core-3.0.1.jar;C:\Users\Administrator\.m2\repository\com\baomidou\mybatis-plus-annotation\3.0.1\mybatis-plus-annotation-3.0.1.jar;C:\Users\Administrator\.m2\repository\com\github\jsqlparser\jsqlparser\1.2\jsqlparser-1.2.jar;C:\Users\Administrator\.m2\repository\com\baomidou\mybatis-plus-generator\3.0.1\mybatis-plus-generator-3.0.1.jar;C:\Users\Administrator\.m2\repository\org\apache\velocity\velocity-engine-core\2.0\velocity-engine-core-2.0.jar;C:\Users\Administrator\.m2\repository\org\apache\commons\commons-lang3\3.8.1\commons-lang3-3.8.1.jar;C:\Users\Administrator\.m2\repository\org\freemarker\freemarker\2.3.28\freemarker-2.3.28.jar;C:\Users\Administrator\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\2.1.6.RELEASE\spring-boot-autoconfigure-2.1.6.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\boot\spring-boot-configuration-processor\2.1.6.RELEASE\spring-boot-configuration-processor-2.1.6.RELEASE.jar;C:\Users\Administrator\.m2\repository\com\alibaba\druid-spring-boot-starter\1.1.10\druid-spring-boot-starter-1.1.10.jar;C:\Users\Administrator\.m2\repository\com\alibaba\druid\1.1.10\druid-1.1.10.jar;C:\Users\Administrator\.m2\repository\org\springframework\boot\spring-boot-starter-data-redis\2.1.2.RELEASE\spring-boot-starter-data-redis-2.1.2.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\data\spring-data-redis\2.1.9.RELEASE\spring-data-redis-2.1.9.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\data\spring-data-keyvalue\2.1.9.RELEASE\spring-data-keyvalue-2.1.9.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\spring-tx\5.1.8.RELEASE\spring-tx-5.1.8.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\spring-oxm\5.1.8.RELEASE\spring-oxm-5.1.8.RELEASE.jar;C:\Users\Administrator\.m2\repository\io\lettuce\lettuce-core\5.1.7.RELEASE\lettuce-core-5.1.7.RELEASE.jar;C:\Users\Administrator\.m2\repository\io\netty\netty-common\4.1.36.Final\netty-common-4.1.36.Final.jar;C:\Users\Administrator\.m2\repository\io\netty\netty-handler\4.1.36.Final\netty-handler-4.1.36.Final.jar;C:\Users\Administrator\.m2\repository\io\netty\netty-buffer\4.1.36.Final\netty-buffer-4.1.36.Final.jar;C:\Users\Administrator\.m2\repository\io\netty\netty-codec\4.1.36.Final\netty-codec-4.1.36.Final.jar;C:\Users\Administrator\.m2\repository\io\netty\netty-transport\4.1.36.Final\netty-transport-4.1.36.Final.jar;C:\Users\Administrator\.m2\repository\io\netty\netty-resolver\4.1.36.Final\netty-resolver-4.1.36.Final.jar;C:\Users\Administrator\.m2\repository\io\projectreactor\reactor-core\3.2.10.RELEASE\reactor-core-3.2.10.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\reactivestreams\reactive-streams\1.0.2\reactive-streams-1.0.2.jar;C:\Users\Administrator\.m2\repository\org\springframework\boot\spring-boot-starter-cache\2.1.2.RELEASE\spring-boot-starter-cache-2.1.2.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\spring-context-support\5.1.8.RELEASE\spring-context-support-5.1.8.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\apache\commons\commons-pool2\2.6.0\commons-pool2-2.6.0.jar;C:\Users\Administrator\.m2\repository\org\springframework\boot\spring-boot-starter-data-elasticsearch\2.1.2.RELEASE\spring-boot-starter-data-elasticsearch-2.1.2.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\data\spring-data-elasticsearch\3.1.9.RELEASE\spring-data-elasticsearch-3.1.9.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\data\spring-data-commons\2.1.9.RELEASE\spring-data-commons-2.1.9.RELEASE.jar;C:\Users\Administrator\.m2\repository\joda-time\joda-time\2.10.2\joda-time-2.10.2.jar;C:\Users\Administrator\.m2\repository\org\elasticsearch\client\transport\6.4.3\transport-6.4.3.jar;C:\Users\Administrator\.m2\repository\org\elasticsearch\elasticsearch\6.4.3\elasticsearch-6.4.3.jar;C:\Users\Administrator\.m2\repository\org\elasticsearch\elasticsearch-core\6.4.3\elasticsearch-core-6.4.3.jar;C:\Users\Administrator\.m2\repository\org\elasticsearch\elasticsearch-secure-sm\6.4.3\elasticsearch-secure-sm-6.4.3.jar;C:\Users\Administrator\.m2\repository\org\elasticsearch\elasticsearch-x-content\6.4.3\elasticsearch-x-content-6.4.3.jar;C:\Users\Administrator\.m2\repository\com\fasterxml\jackson\dataformat\jackson-dataformat-smile\2.9.9\jackson-dataformat-smile-2.9.9.jar;C:\Users\Administrator\.m2\repository\com\fasterxml\jackson\dataformat\jackson-dataformat-yaml\2.9.9\jackson-dataformat-yaml-2.9.9.jar;C:\Users\Administrator\.m2\repository\com\fasterxml\jackson\dataformat\jackson-dataformat-cbor\2.9.9\jackson-dataformat-cbor-2.9.9.jar;C:\Users\Administrator\.m2\repository\org\apache\lucene\lucene-core\7.4.0\lucene-core-7.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\lucene\lucene-analyzers-common\7.4.0\lucene-analyzers-common-7.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\lucene\lucene-backward-codecs\7.4.0\lucene-backward-codecs-7.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\lucene\lucene-grouping\7.4.0\lucene-grouping-7.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\lucene\lucene-highlighter\7.4.0\lucene-highlighter-7.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\lucene\lucene-join\7.4.0\lucene-join-7.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\lucene\lucene-memory\7.4.0\lucene-memory-7.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\lucene\lucene-misc\7.4.0\lucene-misc-7.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\lucene\lucene-queries\7.4.0\lucene-queries-7.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\lucene\lucene-queryparser\7.4.0\lucene-queryparser-7.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\lucene\lucene-sandbox\7.4.0\lucene-sandbox-7.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\lucene\lucene-spatial\7.4.0\lucene-spatial-7.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\lucene\lucene-spatial-extras\7.4.0\lucene-spatial-extras-7.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\lucene\lucene-spatial3d\7.4.0\lucene-spatial3d-7.4.0.jar;C:\Users\Administrator\.m2\repository\org\apache\lucene\lucene-suggest\7.4.0\lucene-suggest-7.4.0.jar;C:\Users\Administrator\.m2\repository\org\elasticsearch\elasticsearch-cli\6.4.3\elasticsearch-cli-6.4.3.jar;C:\Users\Administrator\.m2\repository\net\sf\jopt-simple\jopt-simple\5.0.2\jopt-simple-5.0.2.jar;C:\Users\Administrator\.m2\repository\com\carrotsearch\hppc\0.7.1\hppc-0.7.1.jar;C:\Users\Administrator\.m2\repository\com\tdunning\t-digest\3.2\t-digest-3.2.jar;C:\Users\Administrator\.m2\repository\org\hdrhistogram\HdrHistogram\2.1.9\HdrHistogram-2.1.9.jar;C:\Users\Administrator\.m2\repository\org\elasticsearch\jna\4.5.1\jna-4.5.1.jar;C:\Users\Administrator\.m2\repository\org\elasticsearch\plugin\reindex-client\6.4.3\reindex-client-6.4.3.jar;C:\Users\Administrator\.m2\repository\org\elasticsearch\client\elasticsearch-rest-client\6.4.3\elasticsearch-rest-client-6.4.3.jar;C:\Users\Administrator\.m2\repository\org\apache\httpcomponents\httpclient\4.5.9\httpclient-4.5.9.jar;C:\Users\Administrator\.m2\repository\org\apache\httpcomponents\httpcore\4.4.11\httpcore-4.4.11.jar;C:\Users\Administrator\.m2\repository\org\apache\httpcomponents\httpasyncclient\4.1.4\httpasyncclient-4.1.4.jar;C:\Users\Administrator\.m2\repository\org\apache\httpcomponents\httpcore-nio\4.4.11\httpcore-nio-4.4.11.jar;C:\Users\Administrator\.m2\repository\commons-codec\commons-codec\1.11\commons-codec-1.11.jar;C:\Users\Administrator\.m2\repository\org\elasticsearch\plugin\lang-mustache-client\6.4.3\lang-mustache-client-6.4.3.jar;C:\Users\Administrator\.m2\repository\com\github\spullara\mustache\java\compiler\0.9.3\compiler-0.9.3.jar;C:\Users\Administrator\.m2\repository\org\elasticsearch\plugin\percolator-client\6.4.3\percolator-client-6.4.3.jar;C:\Users\Administrator\.m2\repository\org\elasticsearch\plugin\parent-join-client\6.4.3\parent-join-client-6.4.3.jar;C:\Users\Administrator\.m2\repository\org\elasticsearch\plugin\rank-eval-client\6.4.3\rank-eval-client-6.4.3.jar;C:\Users\Administrator\.m2\repository\com\fasterxml\jackson\core\jackson-core\2.11.0\jackson-core-2.11.0.jar;C:\Users\Administrator\.m2\repository\org\elasticsearch\plugin\transport-netty4-client\6.4.3\transport-netty4-client-6.4.3.jar;C:\Users\Administrator\.m2\repository\io\netty\netty-codec-http\4.1.36.Final\netty-codec-http-4.1.36.Final.jar;C:\Users\Administrator\.m2\repository\org\springframework\boot\spring-boot-starter-amqp\2.1.2.RELEASE\spring-boot-starter-amqp-2.1.2.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\spring-messaging\5.1.8.RELEASE\spring-messaging-5.1.8.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\amqp\spring-rabbit\2.1.7.RELEASE\spring-rabbit-2.1.7.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\amqp\spring-amqp\2.1.7.RELEASE\spring-amqp-2.1.7.RELEASE.jar;C:\Users\Administrator\.m2\repository\org\springframework\retry\spring-retry\1.2.4.RELEASE\spring-retry-1.2.4.RELEASE.jar;C:\Users\Administrator\.m2\repository\com\rabbitmq\amqp-client\5.4.3\amqp-client-5.4.3.jar" cn.dblearn.blog.BlogApplication

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.6.RELEASE)

2020-09-03 13:24:06.073  INFO 20988 --- [           main] cn.dblearn.blog.BlogApplication          : Starting BlogApplication on PC-20200409QOZX with PID 20988 (E:\dbblog-master\dbblog-backend\dbblog-search\target\classes started by Administrator in E:\dbblog-master\dbblog-backend)
2020-09-03 13:24:06.132 DEBUG 20988 --- [           main] cn.dblearn.blog.BlogApplication          : Running with Spring Boot v2.1.6.RELEASE, Spring v5.1.8.RELEASE
2020-09-03 13:24:06.133  INFO 20988 --- [           main] cn.dblearn.blog.BlogApplication          : The following profiles are active: dev
2020-09-03 13:24:09.826  INFO 20988 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode!
2020-09-03 13:24:09.829  INFO 20988 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data repositories in DEFAULT mode.
2020-09-03 13:24:09.948  INFO 20988 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 113ms. Found 1 repository interfaces.
2020-09-03 13:24:09.961  INFO 20988 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode!
2020-09-03 13:24:09.963  INFO 20988 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data repositories in DEFAULT mode.
2020-09-03 13:24:09.990  INFO 20988 --- [           main] .RepositoryConfigurationExtensionSupport : Spring Data Redis - Could not safely identify store assignment for repository candidate interface cn.dblearn.blog.search.mapper.ArticleRepository.
2020-09-03 13:24:09.990  INFO 20988 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 16ms. Found 0 repository interfaces.
2020-09-03 13:24:10.354  INFO 20988 --- [           main] ptablePropertiesBeanFactoryPostProcessor : Post-processing PropertySource instances
2020-09-03 13:24:10.431  INFO 20988 --- [           main] c.u.j.EncryptablePropertySourceConverter : Converting PropertySource configurationProperties [org.springframework.boot.context.properties.source.ConfigurationPropertySourcesPropertySource] to AOP Proxy
2020-09-03 13:24:10.431  INFO 20988 --- [           main] c.u.j.EncryptablePropertySourceConverter : Converting PropertySource servletConfigInitParams [org.springframework.core.env.PropertySource$StubPropertySource] to EncryptablePropertySourceWrapper
2020-09-03 13:24:10.432  INFO 20988 --- [           main] c.u.j.EncryptablePropertySourceConverter : Converting PropertySource servletContextInitParams [org.springframework.core.env.PropertySource$StubPropertySource] to EncryptablePropertySourceWrapper
2020-09-03 13:24:10.432  INFO 20988 --- [           main] c.u.j.EncryptablePropertySourceConverter : Converting PropertySource systemProperties [org.springframework.core.env.PropertiesPropertySource] to EncryptableMapPropertySourceWrapper
2020-09-03 13:24:10.432  INFO 20988 --- [           main] c.u.j.EncryptablePropertySourceConverter : Converting PropertySource systemEnvironment [org.springframework.boot.env.SystemEnvironmentPropertySourceEnvironmentPostProcessor$OriginAwareSystemEnvironmentPropertySource] to EncryptableMapPropertySourceWrapper
2020-09-03 13:24:10.432  INFO 20988 --- [           main] c.u.j.EncryptablePropertySourceConverter : Converting PropertySource random [org.springframework.boot.env.RandomValuePropertySource] to EncryptablePropertySourceWrapper
2020-09-03 13:24:10.432  INFO 20988 --- [           main] c.u.j.EncryptablePropertySourceConverter : Converting PropertySource applicationConfig: [classpath:/application-dev.yml] [org.springframework.boot.env.OriginTrackedMapPropertySource] to EncryptableMapPropertySourceWrapper
2020-09-03 13:24:10.433  INFO 20988 --- [           main] c.u.j.EncryptablePropertySourceConverter : Converting PropertySource applicationConfig: [classpath:/application.yml] [org.springframework.boot.env.OriginTrackedMapPropertySource] to EncryptableMapPropertySourceWrapper
2020-09-03 13:24:10.453  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'shiroConfig' of type [cn.dblearn.blog.auth.config.ShiroConfig$$EnhancerBySpringCGLIB$$5615dfe2] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:10.534  INFO 20988 --- [           main] c.u.j.filter.DefaultLazyPropertyFilter   : Property Filter custom Bean not found with name 'encryptablePropertyFilter'. Initializing Default Property Filter
___  ___       ______         _    _        ______  _             
|  \/  |       | ___ \       | |  (_)       | ___ \| |            
| .  . | _   _ | |_/ /  __ _ | |_  _  ___   | |_/ /| | _   _  ___ 
| |\/| || | | || ___ \ / _` || __|| |/ __|  |  __/ | || | | |/ __|
| |  | || |_| || |_/ /| (_| || |_ | |\__ \  | |    | || |_| |\__ \
\_|  |_/ \__, |\____/  \__,_| \__||_||___/  \_|    |_| \__,_||___/
          __/ |                                                   
         |___/                                              3.0.1

2020-09-03 13:24:10.689  INFO 20988 --- [           main] c.u.j.r.DefaultLazyPropertyResolver      : Property Resolver custom Bean not found with name 'encryptablePropertyResolver'. Initializing Default Property Resolver
2020-09-03 13:24:10.691  INFO 20988 --- [           main] c.u.j.d.DefaultLazyPropertyDetector      : Property Detector custom Bean not found with name 'encryptablePropertyDetector'. Initializing Default Property Detector
2020-09-03 13:24:10.697  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'mybatis-plus-com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties' of type [com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:10.703  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'mybatisPlusConfig' of type [cn.dblearn.blog.config.MybatisPlusConfig$$EnhancerBySpringCGLIB$$d5c3ad5a] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:10.708  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'paginationInterceptor' of type [com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:10.714  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration' of type [com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration$$EnhancerBySpringCGLIB$$e3296c0b] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:10.717  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure' of type [com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure$$EnhancerBySpringCGLIB$$bf0cf4e3] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:10.719  INFO 20988 --- [           main] c.a.d.s.b.a.DruidDataSourceAutoConfigure : Init DruidDataSource
2020-09-03 13:24:10.807  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'spring.datasource-org.springframework.boot.autoconfigure.jdbc.DataSourceProperties' of type [org.springframework.boot.autoconfigure.jdbc.DataSourceProperties] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:10.812  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'com.alibaba.druid.spring.boot.autoconfigure.stat.DruidFilterConfiguration' of type [com.alibaba.druid.spring.boot.autoconfigure.stat.DruidFilterConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:10.841  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'statFilter' of type [com.alibaba.druid.filter.stat.StatFilter] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:16.020  INFO 20988 --- [           main] com.alibaba.druid.pool.DruidDataSource   : {dataSource-1} inited
2020-09-03 13:24:16.020  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'dataSource' of type [com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceWrapper] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:16.061  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'mybatisPlusAutoFillHandler' of type [cn.dblearn.blog.common.fill.MybatisPlusAutoFillHandler] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:16.879  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'sqlSessionFactory' of type [org.apache.ibatis.session.defaults.DefaultSqlSessionFactory] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:16.912  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'sqlSessionTemplate' of type [org.mybatis.spring.SqlSessionTemplate] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:16.913  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'sysUserMapper' of type [org.mybatis.spring.mapper.MapperFactoryBean] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:16.915  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'sysUserMapper' of type [com.sun.proxy.$Proxy80] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:16.918  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'sysMenuMapper' of type [org.mybatis.spring.mapper.MapperFactoryBean] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:16.919  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'sysMenuMapper' of type [com.sun.proxy.$Proxy81] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:16.945  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'spring.redis-org.springframework.boot.autoconfigure.data.redis.RedisProperties' of type [org.springframework.boot.autoconfigure.data.redis.RedisProperties] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:16.948  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.boot.autoconfigure.data.redis.LettuceConnectionConfiguration' of type [org.springframework.boot.autoconfigure.data.redis.LettuceConnectionConfiguration$$EnhancerBySpringCGLIB$$ba7abdbb] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:17.505  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'lettuceClientResources' of type [io.lettuce.core.resource.DefaultClientResources] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:17.632  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'redisConnectionFactory' of type [org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:17.633  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'redisConfig' of type [cn.dblearn.blog.config.RedisConfig$$EnhancerBySpringCGLIB$$bc71f5c8] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:17.650  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'redisTemplate' of type [org.springframework.data.redis.core.RedisTemplate] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:17.653  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration' of type [org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration$$EnhancerBySpringCGLIB$$9af82aad] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:17.657  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'stringRedisTemplate' of type [org.springframework.data.redis.core.StringRedisTemplate] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:17.663  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'valueOperations' of type [org.springframework.data.redis.core.DefaultValueOperations] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:17.668  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'hashOperations' of type [org.springframework.data.redis.core.DefaultHashOperations] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:17.672  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'listOperations' of type [org.springframework.data.redis.core.DefaultListOperations] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:17.676  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'setOperations' of type [org.springframework.data.redis.core.DefaultSetOperations] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:17.685  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'zSetOperations' of type [org.springframework.data.redis.core.DefaultZSetOperations] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:17.685  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'redisUtils' of type [cn.dblearn.blog.common.util.RedisUtils] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:17.685  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'sysUserTokenServiceImpl' of type [cn.dblearn.blog.auth.service.impl.SysUserTokenServiceImpl] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:17.686  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'shiroServiceImpl' of type [cn.dblearn.blog.auth.service.impl.ShiroServiceImpl] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:17.686  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'OAuth2Realm' of type [cn.dblearn.blog.auth.OAuth2Realm] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:17.719  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'sessionManager' of type [org.apache.shiro.web.session.mgt.DefaultWebSessionManager] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:18.054  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'securityManager' of type [org.apache.shiro.web.mgt.DefaultWebSecurityManager] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:18.083  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'authorizationAttributeSourceAdvisor' of type [org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:18.138  INFO 20988 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$a560ff71] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-09-03 13:24:18.776  INFO 20988 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2020-09-03 13:24:18.827  INFO 20988 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2020-09-03 13:24:18.828  INFO 20988 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.21]
2020-09-03 13:24:18.998  INFO 20988 --- [           main] o.a.c.c.C.[.[localhost].[/dbblog]        : Initializing Spring embedded WebApplicationContext
2020-09-03 13:24:18.998  INFO 20988 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 12753 ms
2020-09-03 13:24:19.441  INFO 20988 --- [           main] o.s.a.r.c.CachingConnectionFactory       : Attempting to connect to: [192.168.99.100:32920]
2020-09-03 13:24:19.501  INFO 20988 --- [           main] o.s.a.r.c.CachingConnectionFactory       : Created new connection: rabbitConnectionFactory#482ba4b1:0/SimpleConnection@6fe04f2a [delegate=amqp://guest@192.168.99.100:32920/, localPort= 62519]
2020-09-03 13:24:20.169  INFO 20988 --- [           main] o.elasticsearch.plugins.PluginsService   : no modules loaded
2020-09-03 13:24:20.173  INFO 20988 --- [           main] o.elasticsearch.plugins.PluginsService   : loaded plugin [org.elasticsearch.index.reindex.ReindexPlugin]
2020-09-03 13:24:20.174  INFO 20988 --- [           main] o.elasticsearch.plugins.PluginsService   : loaded plugin [org.elasticsearch.join.ParentJoinPlugin]
2020-09-03 13:24:20.174  INFO 20988 --- [           main] o.elasticsearch.plugins.PluginsService   : loaded plugin [org.elasticsearch.percolator.PercolatorPlugin]
2020-09-03 13:24:20.174  INFO 20988 --- [           main] o.elasticsearch.plugins.PluginsService   : loaded plugin [org.elasticsearch.script.mustache.MustachePlugin]
2020-09-03 13:24:20.174  INFO 20988 --- [           main] o.elasticsearch.plugins.PluginsService   : loaded plugin [org.elasticsearch.transport.Netty4Plugin]
2020-09-03 13:24:21.778  INFO 20988 --- [           main] o.s.d.e.c.TransportClientFactoryBean     : Adding transport node : 192.168.99.100:32916
2020-09-03 13:24:52.463 ERROR 20988 --- [           main] .d.e.r.s.AbstractElasticsearchRepository : failed to load elasticsearch nodes : org.elasticsearch.client.transport.NoNodeAvailableException: None of the configured nodes are available: [{#transport#-1}{l9l2tXL0S4uZfIkp-d2ASA}{192.168.99.100}{192.168.99.100:32916}]
2020-09-03 13:24:53.243  INFO 20988 --- [           main] c.u.j.encryptor.DefaultLazyEncryptor     : String Encryptor custom Bean not found with name 'jasyptStringEncryptor'. Initializing Default String Encryptor
2020-09-03 13:24:53.251  INFO 20988 --- [           main] c.u.j.encryptor.DefaultLazyEncryptor     : Encryptor config not found for property jasypt.encryptor.algorithm, using default value: PBEWithMD5AndDES
2020-09-03 13:24:53.252  INFO 20988 --- [           main] c.u.j.encryptor.DefaultLazyEncryptor     : Encryptor config not found for property jasypt.encryptor.keyObtentionIterations, using default value: 1000
2020-09-03 13:24:53.252  INFO 20988 --- [           main] c.u.j.encryptor.DefaultLazyEncryptor     : Encryptor config not found for property jasypt.encryptor.poolSize, using default value: 1
2020-09-03 13:24:53.252  INFO 20988 --- [           main] c.u.j.encryptor.DefaultLazyEncryptor     : Encryptor config not found for property jasypt.encryptor.providerName, using default value: null
2020-09-03 13:24:53.252  INFO 20988 --- [           main] c.u.j.encryptor.DefaultLazyEncryptor     : Encryptor config not found for property jasypt.encryptor.providerClassName, using default value: null
2020-09-03 13:24:53.252  INFO 20988 --- [           main] c.u.j.encryptor.DefaultLazyEncryptor     : Encryptor config not found for property jasypt.encryptor.saltGeneratorClassname, using default value: org.jasypt.salt.RandomSaltGenerator
2020-09-03 13:24:53.254  INFO 20988 --- [           main] c.u.j.encryptor.DefaultLazyEncryptor     : Encryptor config not found for property jasypt.encryptor.stringOutputType, using default value: base64
2020-09-03 13:24:55.423  INFO 20988 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-09-03 13:24:56.555  INFO 20988 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Context refreshed
2020-09-03 13:24:56.573  INFO 20988 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Found 1 custom documentation plugin(s)
2020-09-03 13:24:56.586  INFO 20988 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
2020-09-03 13:24:56.656  INFO 20988 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path '/dbblog'
2020-09-03 13:24:56.661  INFO 20988 --- [           main] cn.dblearn.blog.BlogApplication          : Started BlogApplication in 51.692 seconds (JVM running for 53.688)

Unable to infer base url. This is common when using dynamic servlet registration or when the API is behind an API Gateway. The base url is the root of where all the swagger resources are served. For e.g. if the api is available at http://example.org/api/v2/api-docs then the base url is http://example.org/api/. Please enter the location manually: 
