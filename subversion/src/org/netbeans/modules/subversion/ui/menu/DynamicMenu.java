/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.subversion.ui.menu;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import org.openide.util.actions.Presenter;

/**
 *
 * @author ondra
 */
public abstract class DynamicMenu extends AbstractAction implements Presenter.Menu, Presenter.Popup {
    
    public DynamicMenu (String name) {
        super(name);
    }

    @Override
    public JMenuItem getMenuPresenter() {
        JMenu menu = createMenu();
        org.openide.awt.Mnemonics.setLocalizedText(menu, menu.getText());
        enableMenu(menu);
        return menu;
    }

    @Override
    public JMenuItem getPopupPresenter() {
        JMenu menu = createMenu();
        org.openide.awt.Mnemonics.setLocalizedText(menu, menu.getText());
        enableMenu(menu);
        return menu;
    }

    @Override
    public boolean isEnabled () {
        return true;
    }

    @Override
    public final void actionPerformed (ActionEvent ev) {
        // no operation
    }

    protected abstract JMenu createMenu ();
    
    protected static void enableMenu (JMenu menu) {
        boolean enabled = false;
        for (int i = 0; i < menu.getItemCount(); ++i) {
            JMenuItem item = menu.getItem(i);
            if (item != null && item.isEnabled()) {
                enabled = true;
                break;
            }
        }
        menu.setEnabled(enabled);
    }
}
