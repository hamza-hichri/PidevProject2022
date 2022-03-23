package amin.code.orders.batch.config;

import amin.code.orders.batch.mapper.OrderMapper;
import amin.code.orders.batch.processor.OrderItemProcessor;
import amin.code.orders.batch.writer.OrderWriter;
import amin.code.orders.entity.OrdersDTO;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.Entities.Invitation;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Random;

@EnableBatchProcessing
@Slf4j
@Configuration // configuration
public class BatchConfig {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    DataSource dataSource; // concte a database 


    private final String JOB_NAME = "emailSenderJob";
    private final String STEP_NAME = "emailSenderStep";

    Random random = new Random();
    int randomWithNextInt = random.nextInt();


    @Bean(name = "emailSenderJob")
    public Job emailSenderJob() {
        return this.jobBuilderFactory.get(JOB_NAME+randomWithNextInt)
                .start(emailSenderStep())
                .build();
    }

    @Bean
    public Step emailSenderStep() {
        return this.stepBuilderFactory
                .get(STEP_NAME)
                .<Invitation , Invitation  >chunk(100)
                .reader(activeInvitationReader())// reed oll the data 
                .processor(InvitationItemProcessor()) // send email for invitation.email
                .writer(InvitationWriter()) // ubdete the invitation.email-sent 
                .build();
    }

    @Bean
    public ItemProcessor<Invitation , Invitation  > InvitationItemProcessor() {
        return new InvitationItemProcessor();
    }

    @Bean
    public ItemWriter<Invitation> InvitationWriter() {
        return new InvitationWriter();
    }

    @Bean
    public ItemReader<Invitation> activeOrderReader() {
        String sql = "SELECT * FROM shipped_order WHERE status=1 and email_sent=0";
        return new JdbcCursorItemReaderBuilder<Invitation>()
                .name("activeOrderReader")
                .sql(sql)
                .dataSource(dataSource)
                .rowMapper(new InvitationMapper())
                .build();
    }
}
