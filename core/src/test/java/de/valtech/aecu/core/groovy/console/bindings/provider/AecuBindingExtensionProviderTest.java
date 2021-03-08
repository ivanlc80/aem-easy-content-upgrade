package de.valtech.aecu.core.groovy.console.bindings.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.apache.sling.api.resource.ResourceResolverFactory;
import org.cid15.aem.groovy.console.api.BindingExtensionProvider;
import org.cid15.aem.groovy.console.api.BindingVariable;
import org.cid15.aem.groovy.console.api.context.ScriptContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.day.cq.replication.Replicator;

import de.valtech.aecu.api.groovy.console.bindings.AecuBinding;
import de.valtech.aecu.core.serviceuser.ServiceResourceResolverService;

/**
 * Tests AecuBindingExtensionProvider
 * 
 * @author Roland Gruber
 */
@RunWith(MockitoJUnitRunner.class)
public class AecuBindingExtensionProviderTest {

    @Mock
    private BindingExtensionProvider defaultBindingExtensionProvider;

    @Mock
    private ServiceResourceResolverService resourceResolverService;

    @Mock
    private ResourceResolverFactory resourceResolverFactory;

    @Mock
    private Replicator replicator;

    @InjectMocks
    private AecuBindingExtensionProvider provider;

    @Mock
    private ScriptContext scriptContext;

    @Test
    public void getBindingVariables() {
        Map<String, BindingVariable> variables = provider.getBindingVariables(scriptContext);

        assertEquals(1, variables.size());
        BindingVariable variable = variables.get("aecu");
        assertNotNull(variable);
        AecuBinding binding = (AecuBinding) variable.getValue();
        assertNotNull(binding);
    }
}
