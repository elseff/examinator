package ru.elseff.examinatormicro.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.elseff.examinatormicro.model.Exam;
import ru.elseff.examinatormicro.model.Question;
import ru.elseff.examinatormicro.model.Section;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExamService {

    RestTemplate restTemplate;

    DiscoveryClient discoveryClient;

    public Exam getExam(Map<String, Integer> spec) {
        List<Section> sections = spec
                .entrySet()
                .stream()
                .map(this::getUrl)
                .map(entry -> {
                    Question[] questions = restTemplate.getForObject(entry.getValue(), Question[].class);
                    return new AbstractMap.SimpleEntry<>(entry.getKey(), // name of questions section
                            Arrays.asList(Objects.requireNonNull(questions))); // questions
                })
                .map(list ->
                        Section.builder()
                                .name(list.getKey())
                                .questions(list.getValue())
                                .build())
                .collect(Collectors.toList());

        return Exam.builder()
                .title("EXAM")
                .sections(sections)
                .build();
    }

    // name of section : url
    private Map.Entry<String, String> getUrl(Map.Entry<String, Integer> entry) {
        ServiceInstance serviceInstance = discoveryClient.getInstances(entry.getKey()).get(0);
        return new AbstractMap.SimpleEntry<>(entry.getKey(),
                ((EurekaServiceInstance) serviceInstance)
                        .getInstanceInfo()
                        .getHomePageUrl() + "api/questions?amount=" + entry.getValue());
    }
}
